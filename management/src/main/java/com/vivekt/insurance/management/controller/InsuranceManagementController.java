package com.vivekt.insurance.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivekt.insurance.management.dto.EmployeeDTO;
import com.vivekt.insurance.management.dto.EmployeeEnrollmentDashboard;
import com.vivekt.insurance.management.service.InsuranceManagementService;

@RestController
@RequestMapping("/insurance")
public class InsuranceManagementController {

    @Autowired
    private InsuranceManagementService service;

    @GetMapping("/dashboard/employee/{id}")
    public EmployeeEnrollmentDashboard getEmployee(
            @PathVariable Long id) {

        return service.getEmployeeDashboard(id);
    }
}