package com.example.webapp_employee_management_system.service;

import com.example.webapp_employee_management_system.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getALlEmployees();

    Employee getEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeById(Long id);
}
