package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    private int empId = 1;

    public Employee createEmployee(EmployeeDTO dto) {
        Employee emp = new Employee(empId++, dto.getName(), dto.getSalary());
        employeeList.add(emp);
        return emp;
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        return employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public Employee updateEmployee(int id, EmployeeDTO dto) {
        Employee emp = getEmployeeById(id);
        if (emp != null) {
            employeeList.remove(emp);
            Employee updated = new Employee(id, dto.getName(), dto.getSalary());
            employeeList.add(updated);
            return updated;
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employeeList.removeIf(e -> e.getId() == id);
    }
}
