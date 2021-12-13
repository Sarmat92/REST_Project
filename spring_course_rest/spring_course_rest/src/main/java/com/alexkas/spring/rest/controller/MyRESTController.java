package com.alexkas.spring.rest.controller;

import com.alexkas.spring.rest.entity.Employee;
import com.alexkas.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> showAllEmployee() {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
}
