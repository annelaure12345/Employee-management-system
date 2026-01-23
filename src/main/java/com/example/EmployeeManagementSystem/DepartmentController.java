package com.example.EmployeeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllDepartments(Model model){
        List<Department> departments=departmentService.getAllDepartments();
        model.addAttribute("departments",departments);
        return "department-list";
    }

    @GetMapping("/add")
        public String showAddDepartmentForm(Model model){
        model.addAttribute("department", new Department());
        return "department-form";
        }
    @GetMapping("/edit/{id}")
    public String showEditDepartmentForm(@PathVariable Long id, Model model){
        Optional<Department> department=departmentService.getDepartmentById(id);
        if(department.isPresent()){
            model.addAttribute("department",department.get());
            return "department-form";
        }else{
           return "redirect:/departments";
        }
    }
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute Department department){
        departmentService.saveDepartment(department);
        return "redirect:/departments";

    }
    @GetMapping("/delete/{id}")
            public String deleteDepartment(Long id){
        departmentService.deleteDepartment(id);
        return "redirect:/departments/";
    }

}


