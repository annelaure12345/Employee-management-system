package com.example.EmployeeManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    // Get all employees
    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Create employee
    @PostMapping
    public EmployeeResponseDto saveEmployee(@RequestBody EmployeeRequestDto dto) {
        return employeeService.saveEmployee(dto);
    }

    // Update employee
    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto dto) {
        return employeeService.updateEmployee(id, dto);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    // Get all departments
    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }
}
