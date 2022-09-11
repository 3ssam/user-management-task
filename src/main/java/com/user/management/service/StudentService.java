package com.user.management.service;

import com.user.management.models.Student;
import com.user.management.models.DTO.StudentDTO;
import com.user.management.projection.StudentProjection;
import com.user.management.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentProjection> createStudents(List<StudentDTO> students) {
        List<StudentProjection> listOfStudents = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            listOfStudents.add(createStudent(students.get(i)));
        }
        return listOfStudents;
    }

    @Transactional
    public StudentProjection createStudent(StudentDTO StudentDTO) {
        Student Student = new Student();
        Student.setAddress(StudentDTO.getAddress());
        Student.setClassLevel(StudentDTO.getClassLevel());
        Student.setFirstName(StudentDTO.getFirstName());
        Student.setLastName(StudentDTO.getLastName());
        Student.setFullName(StudentDTO.getFullName());
        Student.setAge(StudentDTO.getAge());
        Student.setGrade(StudentDTO.getGrade());
        Student.setSchoolName(StudentDTO.getSchoolName());
        Student.setStudentId(StudentDTO.getStudentId());
        Student = studentRepository.save(Student);
        return studentRepository.getStudentById(Student.getId());
    }

    @Transactional
    public StudentProjection updateStudent(StudentDTO StudentDTO, Long id) throws Exception {
        Student Student = studentRepository.findById(id).get();
        if (Student == null) {
            throw new Exception("Student not found");
        }
        Student.setAddress(StudentDTO.getAddress());
        Student.setClassLevel(StudentDTO.getClassLevel());
        Student.setFirstName(StudentDTO.getFirstName());
        Student.setLastName(StudentDTO.getLastName());
        Student.setFullName(StudentDTO.getFullName());
        Student.setAge(StudentDTO.getAge());
        Student.setGrade(StudentDTO.getGrade());
        Student.setSchoolName(StudentDTO.getSchoolName());
        Student.setStudentId(StudentDTO.getStudentId());
        Student = studentRepository.save(Student);
        return studentRepository.getStudentById(Student.getId());
    }


    public List<StudentProjection> getAllStudents() {
        return studentRepository.findAllBy();
    }

    public StudentProjection getStudent(Long id) throws Exception {
        StudentProjection StudentProjection = studentRepository.getStudentById(id);
        if (StudentProjection == null) {
            throw new Exception("Student not found");
        }
        return StudentProjection;
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


}
