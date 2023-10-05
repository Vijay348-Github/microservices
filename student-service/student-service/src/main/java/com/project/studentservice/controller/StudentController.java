package com.project.studentservice.controller;

import com.project.studentservice.model.Student;
import com.project.studentservice.repository.StudentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
public class StudentController {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/post")
    public Student addStudent(@RequestBody Student student){
//        logger.info("student added");
        return studentRepository.add(student);
    }

    @GetMapping("/getall")
    public List<Student> findAll(){
//        logger.info("all students list :");
        return studentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Student findStudentById(@PathVariable Long id){
        return studentRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Student> findByDepartment(@PathVariable("departmentId") Long departmentId) {
//        logger.info("Employee find: departmentId={}");
        return studentRepository.findByDepartment(departmentId);
    }
}
