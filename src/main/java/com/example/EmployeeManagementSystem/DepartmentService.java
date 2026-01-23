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
}
