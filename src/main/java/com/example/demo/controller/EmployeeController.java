package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // UC4 - Create employee
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO dto) {
        return employeeService.createEmployee(dto);
    }

    // UC4 - Get all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // UC4 - Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // UC4 - Update employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    // UC4 - Delete employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return deleted ? "Deleted successfully" : "Employee not found";
    }
}
