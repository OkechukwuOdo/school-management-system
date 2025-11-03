package com.justintime.schoolmanagement.entity;

import com.justintime.schoolmanagement.model.requestDto.ApplicationRequestDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

//@EqualsAndHashCode(callSuper = true)
@Document(collection = "student-application")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StudentApplication {
    @Id
    private String id;
   private Applicants applicants;
   private Program program;
    private String level;
   private LocalDate applicationDate;

    private StudentApplication(ApplicationRequestDto applicationRequestDto){


    }
    public static StudentApplication studentApplicationInstance(ApplicationRequestDto applicationRequestDto){
        return new StudentApplication(applicationRequestDto);
    }
}
