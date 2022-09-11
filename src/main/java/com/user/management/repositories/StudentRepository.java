package com.user.management.repositories;

import com.user.management.models.Student;
import com.user.management.projection.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    StudentProjection getStudentById(Long id);

    List<StudentProjection> findAllBy();
}
