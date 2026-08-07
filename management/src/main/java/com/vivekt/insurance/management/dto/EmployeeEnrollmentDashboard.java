package com.vivekt.insurance.management.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeEnrollmentDashboard {

    private Long employeeId;
    private String employeeName;
    private String organizationName;

    private List<PlanSummary> enrollments;
}
