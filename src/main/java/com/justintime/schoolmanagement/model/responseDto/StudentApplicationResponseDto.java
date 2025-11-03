package com.justintime.schoolmanagement.model.responseDto;

import com.justintime.schoolmanagement.entity.Applicants;
import com.justintime.schoolmanagement.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class StudentApplicationResponseDto {
    private String id;
    private Applicants applicants;
    private Program program;
    private LocalDate applicationDate;
}
