package com.project.depservice.controller;

import com.project.depservice.clients.StudentAsClient;
import com.project.depservice.model.Department;
import com.project.depservice.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/department")
public class DepController {

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(DepController.class);

    @Autowired
    private StudentAsClient studentAsClient;
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/post")
    public Department addDepartment(@RequestBody Department dep){
//        logger.info("department added ");
        return departmentRepository.addDepartmant(dep);
    }

    @GetMapping("/get")
    public List<Department> getAllDepartments(){
//        logger.info("Departments found: id={}");
        return departmentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Department findById(@PathVariable Long id) {
//        logger.info("Department find: id={}");
        return departmentRepository.findDepartmentById(id);
    }

    @GetMapping("/with-students")
    public List<Department> findAllWithStudents() {
//        logger.info("Department find");
        List<Department> departmentList
                = departmentRepository.findAll();

        departmentList.forEach(
                department -> department.setStudents(
                        studentAsClient.findStudentByDepartment(department.getId())));
        return  departmentList;
    }

}
