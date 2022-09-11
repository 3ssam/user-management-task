package com.user.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "fullName", "studentId", "age", "address", "grade"})
public interface StudentProjection {
    Long getId();

    Integer getAge();

    String getFullName();

    String getStudentId();

    String getAddress();

    String getGrade();
}
