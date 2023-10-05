package com.project.depservice.clients;

import com.project.depservice.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface StudentAsClient {


    @GetExchange("student/department/{depId}")
    public List<Student> findStudentByDepartment(@PathVariable("depId") Long depId);
}
