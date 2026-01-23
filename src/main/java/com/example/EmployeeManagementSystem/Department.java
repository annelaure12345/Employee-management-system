package com.example.EmployeeManagementSystem;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Department")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String departmentName;

    @OneToMany(mappedBy="department")
        private List<Employee> employees;

    public long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
