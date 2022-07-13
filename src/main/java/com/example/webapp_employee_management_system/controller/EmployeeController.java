package com.example.webapp_employee_management_system.controller;

import com.example.webapp_employee_management_system.entity.Employee;
import com.example.webapp_employee_management_system.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // OPEN 'HOME' PAGE BY GETTING ALL EMPLOYEES
    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("listEmployees",employeeService.getALlEmployees());
        return "home";
    }

    //OPEN 'NEW-EMPLOYEE-FORM' PAGE TO SAVE NEW EMPLOYEE
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee-form";
    }

    //FIRST SAVE THE EMPLOYEE RECEIVED FROM 'NEW-EMPLOYEE-FORM' AND THEN DISPLAY 'HOME' PAGE
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee, Model model){
        model.addAttribute("newEmployee", employeeService.saveEmployee(employee));
        return "redirect:/employees";
    }

    // OPEN 'UPDATE-EMPLOYEE-FORM' PAGE TO EDIT THE EMPLOYEE DATA
    @GetMapping("/showUpdateEmployeeForm/{id}")
    public String showUpdateEmployeeForm(Model model, @PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update-employee-form";
    }

    @GetMapping("/deleteEmployeeById/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}
