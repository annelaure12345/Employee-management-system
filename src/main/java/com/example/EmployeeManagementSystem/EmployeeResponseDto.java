package com.example.EmployeeManagementSystem;

public class EmployeeResponseDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Double salary;
    private String imageUrl;
    private String departmentName;

    // getters
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
