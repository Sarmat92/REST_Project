package com.alexkas.spring.rest.controller;

import com.alexkas.spring.rest.entity.Employee;
import com.alexkas.spring.rest.exception_handling.EmployeeIncorrectDate;
import com.alexkas.spring.rest.exception_handling.NoSuchEmployeeException;
import com.alexkas.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> showAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database.");
        }
        return employee;
    }
}
