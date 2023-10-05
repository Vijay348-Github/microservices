package com.project.studentservice.repository;

import com.project.studentservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository {

    private final List<Student> students
            = new ArrayList<>();

    public Student add(Student student) {
        students.add(student);
        return student;
    }

    public Student findById(Long id) {
        return students.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Student> findAll() {
        return students;
    }

    public List<Student> findByDepartment(Long departmentId) {
        return students.stream()
                .filter(a -> a.depId().equals(departmentId))
                .toList();
    }
}
