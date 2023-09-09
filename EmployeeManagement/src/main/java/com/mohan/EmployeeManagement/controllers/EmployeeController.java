package com.mohan.EmployeeManagement.controllers;

import com.mohan.EmployeeManagement.models.Employee;
import com.mohan.EmployeeManagement.models.Report;
import com.mohan.EmployeeManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("employee/report/{id}")
    public Report getReport(@PathVariable Integer id){
        return employeeService.getReport(id);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return employeeService.deleteById(id);
    }
}
