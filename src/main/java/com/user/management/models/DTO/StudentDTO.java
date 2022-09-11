package com.user.management.models.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class StudentDTO {
    @NotBlank(message = "This field is required field")
    private String firstName;
    @NotBlank(message = "This field is required field")
    private String lastName;
    @NotBlank(message = "This field is required field")
    private String fullName;
    @NotBlank(message = "This field is required field")
    private String studentId;
    @NotNull(message = "This field is required field")
    private Integer age;
    @NotBlank(message = "This field is required field")
    private String address;
    @NotBlank(message = "This field is required field")
    private String grade;
    private String schoolName;
    private String classLevel;

}
