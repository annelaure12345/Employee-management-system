package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeManagementSystem.EmployeeRequestDto;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // ✅ GET ALL
    public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // ✅ GET ONE
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return mapToDto(employee);
    }

    // ✅ CREATE
    public EmployeeResponseDto saveEmployee(EmployeeRequestDto dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Employee employee = new Employee();
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setEmail(dto.getEmail());
        employee.setImageUrl(dto.getImageUrl());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);
        return mapToDto(saved);
    }

    // ✅ UPDATE
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto dto) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existing.setFirstname(dto.getFirstname());
        existing.setLastname(dto.getLastname());
        existing.setEmail(dto.getEmail());
        existing.setImageUrl(dto.getImageUrl());
        existing.setSalary(dto.getSalary());
        existing.setDepartment(department);

        Employee updated = employeeRepository.save(existing);
        return mapToDto(updated);
    }

    // ✅ DELETE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // 🔁 ENTITY → DTO MAPPER
    private EmployeeResponseDto mapToDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();

        dto.setId(employee.getId());
        dto.setFirstname(employee.getFirstname());
        dto.setLastname(employee.getLastname());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        dto.setImageUrl(employee.getImageUrl());

        dto.setDepartmentName(
                employee.getDepartment() != null
                        ? employee.getDepartment().getDepartmentName()
                        : null
        );

        return dto;
    }
}
