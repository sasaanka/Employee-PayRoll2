package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/dummy")
    public String getDummy() {
        return "Payroll App is up and running!";
    }
}
