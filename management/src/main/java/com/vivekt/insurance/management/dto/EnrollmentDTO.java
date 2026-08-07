package com.vivekt.insurance.management.dto;

import lombok.Data;

@Data
public class EnrollmentDTO {

    private Long enrollmentId;
    private Long employeeId;
    private Long planId;
    private String status;
}
