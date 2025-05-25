package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private int empId = 1;

    // UC4 - Create employee
    public Employee createEmployee(EmployeeDTO dto) {
        Employee emp = new Employee(empId++, dto.getName(), dto.getSalary());
        employeeList.add(emp);
        log.info("Created Employee: {}", emp);
        return emp;
    }

    // UC4 - Get all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees. Total: {}", employeeList.size());
        return employeeList;
    }

    // UC4 - Get employee by ID
    public Employee getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UC4 - Update employee
    public Employee updateEmployee(int id, EmployeeDTO dto) {
        log.info("Updating employee with ID: {}", id);
        Employee existingEmp = getEmployeeById(id);
        if (existingEmp != null) {
            employeeList.remove(existingEmp);
            Employee updatedEmp = new Employee(id, dto.getName(), dto.getSalary());
            employeeList.add(updatedEmp);
            log.info("Updated Employee: {}", updatedEmp);
            return updatedEmp;
        }
        log.warn("Employee with ID {} not found for update", id);
        return null;
    }

    // UC4 - Delete employee
    public boolean deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(e -> e.getId() == id);
        if (removed) {
            log.info("Deleted employee with ID: {}", id);
        } else {
            log.warn("Failed to delete. Employee ID {} not found", id);
        }
        return removed;
    }
}
