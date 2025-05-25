package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public String getEmployee() {
        return "GET - Employee Data";
    }

    @PostMapping
    public String createEmployee() {
        return "POST - Create Employee";
    }

    @PutMapping
    public String updateEmployee() {
        return "PUT - Update Employee";
    }

    @DeleteMapping
    public String deleteEmployee() {
        return "DELETE - Delete Employee";
    }
}
