package com.mohan.EmployeeManagement.services;

import com.mohan.EmployeeManagement.models.Employee;
import com.mohan.EmployeeManagement.models.Report;
import com.mohan.EmployeeManagement.repositories.EmployeeRepo;
import com.mohan.EmployeeManagement.repositories.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepo reportRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public ResponseEntity<String> addReport(Report report) {
        Employee existingEmployee = employeeRepo.findById(report.getEmployee().getEmpId()).orElse(null);
        if(existingEmployee == null){
            return new ResponseEntity<>("Employee with this Id doesn't exist", HttpStatus.NOT_FOUND);
        }

        reportRepo.save(report);
        return new ResponseEntity<>("report added successfully",HttpStatus.CREATED);
    }

    public Report getReportByEmployee(Employee existingEmployee) {
        return reportRepo.findByEmployee(existingEmployee);
    }

    public Report getReportById(Integer id) {
        return reportRepo.findById(id).orElse(null);
    }

    public ResponseEntity<String> updateById(Integer id,Report report) {
        Report existingReport = reportRepo.findById(id).orElse(null);
        if(existingReport == null){
            return new ResponseEntity<>("Report id is not valid",HttpStatus.NOT_FOUND);
        }

        if(report.getEmployee().getEmpId() != null){
            Employee employee = employeeRepo.findById(report.getEmployee().getEmpId()).orElse(null);

            if(employee == null){
                return new ResponseEntity<>("Employee with id doesn't exits",HttpStatus.NOT_FOUND);
            }else {
                existingReport.setEmployee(employee);
            }
        }
        if(report.getAttendance() != null){
            existingReport.setAttendance(report.getAttendance());
        }
        if(report.getPerformance() !=  null){
            existingReport.setPerformance(report.getPerformance());
        }

        reportRepo.save(existingReport);
        return new ResponseEntity<>("Report updated successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteById(Integer id) {
        if(!reportRepo.existsById(id)){
            return new ResponseEntity<>("Report id is not valid",HttpStatus.NOT_FOUND);
        }

        reportRepo.deleteById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
}
