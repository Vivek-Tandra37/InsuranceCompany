package com.vivekt.insurance.management.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long employeeId;
    private String employeeNumber;
    private String firstName;
    private String lastName;
    private String email;
    private Long organizationId;
    private String status;
}
