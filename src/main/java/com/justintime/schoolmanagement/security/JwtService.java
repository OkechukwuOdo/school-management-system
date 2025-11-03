package com.justintime.schoolmanagement.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static javax.crypto.Cipher.SECRET_KEY;

@Log4j2
@RequiredArgsConstructor
@Service
public class JwtService {
    private String kewwy="a1ef2318b600906ea6a79e08fc499ea6a22ab360dd4c3658c5b5b1cbe82b45a815cdb963c1eb5251dc9a957a531b77899036ec537da96107c4de2d17854db028f25fd1ad405a4624ec86499a6508cc1ccc0c7a6125c1cd32a79d0f137c9153fb82f81a18e849540123fbc8cb03a76a1b9e26f0ae213ec11d5d14e01e457e98a0";
    private Long expiration;
    private Long refreshExpiration;
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails) {

        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails) {
        return buildToken(extractClaims,userDetails,expiration);
    }

public String generateFreshToken(UserDetails userDetails){
        return buildToken(new HashMap<>(),userDetails, refreshExpiration);
}
    private String buildToken(
            Map<String, Object> extractClaims,
            UserDetails userDetails,
            Long expiration) {
        return Jwts
                .builder()
                .claims(extractClaims)
                .claim("authorities", userDetails.getAuthorities())
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +    1000*60*24))
                .signWith(getSignInKey())

                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

private Claims extractAllClaims(String token){
    return Jwts.parser()
            .verifyWith(getSignInKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
}

private SecretKey getSignInKey() {
    byte[] bytes = Base64.getDecoder()
            .decode(kewwy.getBytes(StandardCharsets.UTF_8));
    return new SecretKeySpec(bytes, "HmacSHA256"); }

    public String generateRefreshToken(UserDetails userDetails) {
        return generateFreshToken(userDetails);
    }
}
