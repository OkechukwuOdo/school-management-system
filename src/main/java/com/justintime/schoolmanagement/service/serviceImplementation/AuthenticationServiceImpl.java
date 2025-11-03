package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.emailService.EmailDetail;
import com.justintime.schoolmanagement.emailService.EmailService;
import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.PasswordResetToken;
import com.justintime.schoolmanagement.entity.portal.RefreshToken;
import com.justintime.schoolmanagement.model.requestDto.AuthenticationsRequest;
import com.justintime.schoolmanagement.model.requestDto.RefreshRequest;
import com.justintime.schoolmanagement.model.responseDto.AuthenticationResponse;
import com.justintime.schoolmanagement.model.responseDto.TokenResponse;
import com.justintime.schoolmanagement.repository.AppUserRepository;
import com.justintime.schoolmanagement.repository.ForgotPasswordTokenRepository;
import com.justintime.schoolmanagement.repository.RefreshTokenRepository;
import com.justintime.schoolmanagement.security.JwtService;
import com.justintime.schoolmanagement.security.UserDetailService;
import com.justintime.schoolmanagement.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public  class AuthenticationServiceImpl implements AuthenticationService  {
    private final AuthenticationManager authenticationManager;
    private final AppUserRepository appUserRepository;
    private final JwtService securityService;
    private final UserDetailService userDetailService;
    private AuthenticationResponse tokenResponse;
    private final RefreshTokenRepository refreshTokenRepository;
    private final EmailService emailService;
    private final ForgotPasswordTokenRepository forgotPasswordTokenRepository;

    @Override
    public AuthenticationResponse authenticate(AuthenticationsRequest requestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
        if (authentication.isAuthenticated()) {
            String userEmail= authentication.getName();
            UserDetails userDetails= userDetailService.loadUserByUsername(userEmail);
            String accessToken= securityService.generateToken(userDetails);
            String refreshToken= securityService.generateRefreshToken(userDetails);
            AppUser userDetail=appUserRepository.findByEmail(requestDto.getEmail()).orElseThrow();
            tokenResponse = AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .freshToken(refreshToken)
                    .role(userDetail.getRole())
                    .email(userDetail.getEmail())
                    .build();
        }
        return tokenResponse;
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) {

        String requestRefreshToken = request.getToken();
        RefreshToken refreshToken=refreshTokenRepository.findByToken(requestRefreshToken).orElseThrow();
        AppUser appUser=appUserRepository.findById(refreshToken.getUserId()).orElseThrow();
        UserDetails userDetails= userDetailService.loadUserByUsername(appUser.getEmail());
       boolean tokenValid= securityService.isTokenValid(refreshToken.getToken(),userDetails);
       if(tokenValid){
           String accessToken= securityService.generateToken(userDetails);
           tokenResponse = AuthenticationResponse.builder()
                   .accessToken(accessToken)
                   .freshToken(requestRefreshToken)
                   .build();
       }
       else {
           refreshTokenRepository.delete(refreshToken);
       }

        return null;
    }

    @Override
    public void sendResetLink(String email) throws IOException {
        AppUser user = appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setUserId(user);
        resetToken.setToken(token);
        resetToken.setExpiryDate(LocalDateTime.now().plusMinutes(30));
        EmailDetail emailDetail= new EmailDetail();
        emailDetail.setEmailContent(token);
        emailDetail.setToEmail(email);
        emailDetail.setSubject("");
        emailService.sendMail(emailDetail);
        forgotPasswordTokenRepository.save(resetToken);


    }

    @Override
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = forgotPasswordTokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Invalid token"));

        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Token expired");
        }
        AppUser appUser=resetToken.getUserId();
        appUser.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        appUserRepository.save(appUser);
        forgotPasswordTokenRepository.delete(resetToken);

    }

    @Override
    public void changePassword(String token, String newPassword) {

    }
}
