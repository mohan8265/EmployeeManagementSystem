package com.mohan.EmployeeManagement.repositories;

import com.mohan.EmployeeManagement.models.Employee;
import com.mohan.EmployeeManagement.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends JpaRepository<Report,Integer> {
    Report findByEmployee(Employee existingEmployee);
}
