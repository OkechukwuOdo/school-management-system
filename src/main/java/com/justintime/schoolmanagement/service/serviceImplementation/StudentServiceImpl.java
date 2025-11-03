package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Staff;
import com.justintime.schoolmanagement.entity.Student;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.entity.enumz.AppUserRole;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.exceptions.UserAlreadyExistException;
import com.justintime.schoolmanagement.model.requestDto.StudentRequestDto;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StaffResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentResponse;
import com.justintime.schoolmanagement.repository.AppUserRepository;
import com.justintime.schoolmanagement.repository.StudentRepository;
import com.justintime.schoolmanagement.service.StudentService;
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

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;


    @Override
    public StudentResponse registerStudent(StudentRequestDto studentRequestDto) {
        Optional <AppUser> appUser= appUserRepository.findByEmail(studentRequestDto.getEmail());
        log.info("Saving a user {}",appUser);
        if (appUser.isPresent()){
            log.info("Saving a user {}",appUser);
            throw new UserAlreadyExistException("Already Exist");
        }
        String encodedPassword=passwordEncoder.encode(studentRequestDto.getPassword());
        AppUser newUser=AppUser.userInstance(studentRequestDto);
        newUser.setPassword(encodedPassword);
        appUserRepository.save(newUser);
        Student newStudent= Student.studentInstance(studentRequestDto);

        newStudent.setPassword(encodedPassword);
        log.info("Saving a user {}",newStudent.getEmail());
        Student savedStudent = studentRepository.save(newStudent);
        log.info("Saving a user {}",savedStudent);
        return StudentMapper.studentResponseInstance(savedStudent);
    }

    @Override
    public PaginationResponse<StudentResponse, Student> getAllStudent(int offset,int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<Student> page = studentRepository.findAll(pageable);
//        Page<AppUser> page = appUserRepository.findAllByRole(AppUserRole.STUDENT.toString(),pageable);
        List<StudentResponse> filteredList = page.getContent().stream()
                .map(appUser -> (Student)appUser)
                .map(StudentMapper::studentResponseInstance).toList();
        return new PaginationResponse<>(filteredList, page);


    }


    @Override
    public String deleteAStudent(String id) {
        Student student= (Student) studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
        return student.getFirstName()+student.getLastName()+"  "+"deleted ";
    }

    @Override
    public StudentResponse getAStudentById(String staffId) {
        Student student= (Student) studentRepository.findById(staffId).orElseThrow();
        return StudentMapper.studentResponseInstance(student);
    }
}
