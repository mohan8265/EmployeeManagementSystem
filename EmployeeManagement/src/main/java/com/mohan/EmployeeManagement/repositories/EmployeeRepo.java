package com.mohan.EmployeeManagement.repositories;

import com.mohan.EmployeeManagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
