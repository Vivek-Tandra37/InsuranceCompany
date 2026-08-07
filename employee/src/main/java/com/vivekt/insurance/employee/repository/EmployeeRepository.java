package com.vivekt.insurance.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivekt.insurance.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
