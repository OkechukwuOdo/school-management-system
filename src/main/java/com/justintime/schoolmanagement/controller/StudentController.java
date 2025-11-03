package com.justintime.schoolmanagement.controller;

import com.justintime.schoolmanagement.entity.AppUser;
import com.justintime.schoolmanagement.entity.Student;
import com.justintime.schoolmanagement.entity.StudentApplication;
import com.justintime.schoolmanagement.model.requestDto.StudentRequestDto;
import com.justintime.schoolmanagement.model.responseDto.ApiResponse;
import com.justintime.schoolmanagement.model.responseDto.PaginationResponse;
import com.justintime.schoolmanagement.model.responseDto.StudentApplicationResponseDto;
import com.justintime.schoolmanagement.model.responseDto.StudentResponse;
import com.justintime.schoolmanagement.service.StudentService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
private final StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> registerSecondaryStudent(@RequestBody StudentRequestDto studentRequestDto){
        StudentResponse newStaff= studentService.registerStudent(studentRequestDto);
        return ResponseEntity.ok(newStaff);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<ApiResponse<PaginationResponse<StudentResponse, Student>>> getAllStudents(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit
    ){
        return ResponseEntity.ok(ApiResponse.buildSuccessTxn(studentService.getAllStudent(offset,limit)));
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getAStudentById(id)); // Assuming this method exists
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        return ResponseEntity.ok(studentService.deleteAStudent(id));
    }

}
