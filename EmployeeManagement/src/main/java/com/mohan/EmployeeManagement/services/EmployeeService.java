package com.mohan.EmployeeManagement.services;

import com.mohan.EmployeeManagement.models.Employee;
import com.mohan.EmployeeManagement.models.Report;
import com.mohan.EmployeeManagement.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ReportService reportService;

    public ResponseEntity<String> addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public ResponseEntity<String> deleteById(Integer id) {
        if(!employeeRepo.existsById(id)){
            return new ResponseEntity<>("Not a valid id",HttpStatus.NOT_FOUND);
        }else{
            employeeRepo.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
        }
    }

    public Report getReport(Integer id) {
        Employee existingEmployee = employeeRepo.findById(id).orElse(null);
        if(existingEmployee == null){
            throw new IllegalStateException("Employee with given id is not present in database");
        }

        return reportService.getReportByEmployee(existingEmployee);
    }
}
