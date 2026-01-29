package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List <Department> getAllDepartments(){
       return departmentRepository.findAll();
    }
    public Optional  getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }
    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }


    public Department updateDepartment(Long id, Department department) {
        Department existing = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existing.setDepartmentName(department.getDepartmentName());
        // add any other fields your Department entity has
        return departmentRepository.save(existing);
    }

}
