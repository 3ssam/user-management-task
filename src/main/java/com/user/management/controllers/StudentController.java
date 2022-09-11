package com.user.management.controllers;

import com.user.management.models.DTO.StudentDTO;
import com.user.management.response.ApiResponse;
import com.user.management.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "Student API", description = "this API for Students data")
@RequestMapping("student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAuthority('CREATE_STUDENT')")
    @PostMapping()
    public ApiResponse createStudent(@Validated @RequestBody StudentDTO StudentDTO) throws Exception {
        return ApiResponse.created(studentService.createStudent(StudentDTO));
    }

    @PreAuthorize("hasAuthority('CREATE_STUDENT')")
    @PostMapping("students")
    public ApiResponse createStudent(@Validated @RequestBody List<StudentDTO> students) throws Exception {
        return ApiResponse.created(studentService.createStudents(students));
    }

    @PreAuthorize("hasAuthority('UPDATE_STUDENT')")
    @PutMapping("{StudentId}")
    public ApiResponse updateStudent(@PathVariable Long StudentId, @Validated @RequestBody StudentDTO StudentDTO) throws Exception {
        return ApiResponse.updated(studentService.updateStudent(StudentDTO, StudentId));
    }

    @PreAuthorize("hasAuthority('DELETE_STUDENT')")
    @DeleteMapping("{StudentId}")
    public void deleteStudent(@PathVariable Long StudentId) {
        studentService.deleteStudent(StudentId);
    }

    @PreAuthorize("hasAuthority('READ_STUDENT')")
    @GetMapping({"{StudentId}"})
    public ApiResponse getStudent(@PathVariable Long StudentId) throws Exception {
        return ApiResponse.ok(studentService.getStudent(StudentId));
    }

    @PreAuthorize("hasAuthority('READ_ALL_STUDENTS')")
    @GetMapping()
    public ApiResponse getStudents() {
        return ApiResponse.created(studentService.getAllStudents());
    }

}
