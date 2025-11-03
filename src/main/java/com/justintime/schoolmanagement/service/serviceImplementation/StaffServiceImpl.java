package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Staff;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.entity.enumz.StaffType;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.exceptions.UserAlreadyExistException;
import com.justintime.schoolmanagement.model.requestDto.StaffRequestDto;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.repository.AppUserRepository;
import com.justintime.schoolmanagement.repository.StaffRepository;
import com.justintime.schoolmanagement.service.StaffService;
import com.justintime.schoolmanagement.utilz.objectMapper.StaffMapper;
import com.justintime.schoolmanagement.utilz.objectMapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffServiceImpl implements StaffService {
    private final AppUserRepository appUserRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StaffResponseDto createStaff(StaffRequestDto staffRequestDto) {
        Optional <AppUser> appUser= appUserRepository.findByEmail(staffRequestDto.getEmail());
        log.info("Saving a user {}",appUser);
        if (appUser.isPresent()){
            log.info("Saving a user {}",appUser);
            throw new UserAlreadyExistException("Already Exist");
        }
        String encodedPassword= passwordEncoder.encode(staffRequestDto.getPassword());
        AppUser newUser=AppUser.userInstance(staffRequestDto);
        newUser.setPassword(encodedPassword);
        AppUser savedUser=appUserRepository.save(newUser);
        Staff newStaff = Staff.staffInstanceFromRequest(staffRequestDto);

        newStaff.setPassword(encodedPassword);
//        newStaff.setUserId(savedUser.getId());
        Staff newAppUser =  staffRepository.save(newStaff);
        log.info("staff id {}",newAppUser.getId());
        return StaffMapper.staffResponse(newAppUser);
    }

    @Override
    public String deleteAStaff(String id) {
        AppUser staff= staffRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" No User with this Id"));
        staffRepository.deleteById(id);
        return staff.getLastName()+"  "+staff.getFirstName()+" deleted ";
    }

    @Override
    public StaffResponseDto getAStaffById(String staffId) {
        AppUser staff= staffRepository.findById(staffId).orElseThrow(
                ()-> new ResourceNotFoundException(" No User with this Id")
        );
        Staff newStaff= (Staff) staff;
        return StaffMapper.staffResponse(newStaff);
    }

    @Override
    public PaginationResponse<StaffResponseDto, Staff> getALlStaffByType(String staffType, int offset, int limit) {
        List<Staff> listOfStaff= staffRepository.findAll();
        log.info("Returned Staff {}",listOfStaff);

        Pageable pageable = PageRequest.of(offset, limit);
        Page<Staff> page = staffRepository.findAll(pageable);
        List<StaffResponseDto> filteredList = page.getContent().stream()
                .map(appUser -> (Staff)appUser)
                .filter(staff -> staff.getStaffType().toString().equals(staffType))
                .map(StaffMapper::staffResponse).toList();
        return new PaginationResponse<>(filteredList, page);
    }

    @Override
    public PaginationResponse<StaffResponseDto, Staff> getAllStaff(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Staff> page = staffRepository.findAll(pageable);
        List<StaffResponseDto> filteredList = page.getContent().stream()
                .map(appUser -> (Staff)appUser)
                .map(StaffMapper::staffResponse).toList();
        return new PaginationResponse<>(filteredList, page);
    }
}
