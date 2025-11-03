package com.justintime.schoolmanagement.service.serviceImplementation;

import com.justintime.schoolmanagement.entity.Applicants;
import com.justintime.schoolmanagement.entity.Program;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.exceptions.ResourceNotFoundException;
import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.repository.SchoolProgramRepository;
import com.justintime.schoolmanagement.repository.StudentApplicantRepository;
import com.justintime.schoolmanagement.service.StudentApplicationService;
import com.justintime.schoolmanagement.utilz.objectMapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentApplicationServiceImpl implements StudentApplicationService {
    private final StudentApplicantRepository studentApplicantRepository;
    private final SchoolProgramRepository schoolProgramRepository;
    @Override
    public StudentApplicationResponseDto applicationRegistration(ApplicationRequestDto applicationRequestDto) {
        log.info("program ...........kkkkk");
        log.info("program id...........{}",applicationRequestDto.getProgramId());
        log.info("program id...........{}",applicationRequestDto.getPhoneNumber());

        Program program= schoolProgramRepository.findById(applicationRequestDto.getProgramId())
                .orElseThrow(()->new ResourceNotFoundException("No Program with such id"));
        log.info("program {}",program);
        Applicants applicants= Applicants.applicantInstanceFromRequest(applicationRequestDto);
    StudentApplication studentApplication=   studentApplicantRepository.save( StudentApplication.builder()
               .applicants(applicants)
               .program(program)
               .applicationDate(LocalDate.now())
                       .level(applicationRequestDto.getLevel())
                       .applicationDate(LocalDate.now())
               .build());
        return StudentMapper.studentApplicationResponseInstance(studentApplication);
    }


    @Override
    public StudentApplicationResponseDto getApplicantById(String id) {
        StudentApplication allApplications=studentApplicantRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Fount"));
        return StudentMapper.studentApplicationResponseInstance(allApplications);
    }

    @Override
    public PaginationResponse<StudentApplicationResponseDto,StudentApplication> getAllApplication(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<StudentApplication> page = studentApplicantRepository.findAll(pageable);
        Page<StudentApplicationResponseDto> studentApplicationResponseDto=  page.map(StudentMapper::studentApplicationResponseInstance);
        return new PaginationResponse<>(studentApplicationResponseDto.getContent(), page);
    }

}
