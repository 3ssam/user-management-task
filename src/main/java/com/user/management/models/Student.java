package com.user.management.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Entity
public class Student extends BaseEntity {


    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String studentId;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String grade;
    private String schoolName;
    private String classLevel;
}
