package com.mohan.EmployeeManagement.controllers;

import com.mohan.EmployeeManagement.models.Report;
import com.mohan.EmployeeManagement.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;
    @PostMapping("/report")
    public ResponseEntity<String> addReport(@RequestBody Report report ){
        return reportService.addReport(report);
    }
    @GetMapping("/report/{id}")
    public Report getReportById(@PathVariable Integer id){
        return reportService.getReportById(id);
    }
    @PutMapping("/report/{id}")
    public ResponseEntity<String> updateById(@PathVariable Integer id,@RequestBody Report report){
        return reportService.updateById(id,report);
    }
    @DeleteMapping("/report/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return reportService.deleteById(id);
    }
}

