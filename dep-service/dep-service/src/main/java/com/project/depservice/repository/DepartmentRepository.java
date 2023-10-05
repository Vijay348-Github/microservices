package com.project.depservice.repository;

import com.project.depservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    public List<Department> list = new ArrayList<>();

    public Department addDepartmant(Department department){
        list.add(department);
        return department;
    }

    public Department findDepartmentById(Long id){
        return list.stream().filter(
                department -> department.getId().equals(id)
        ).findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return list;
    }

}
