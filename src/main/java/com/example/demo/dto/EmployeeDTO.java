package com.example.demo.dto;

public class EmployeeDTO {
    private String name;
    private long salary;

    public EmployeeDTO() {}

    public EmployeeDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public long getSalary() { return salary; }
    public void setSalary(long salary) { this.salary = salary; }
}
