package com.vivekt.insurance.management.dto;

import lombok.Data;

@Data
public class OrganizationDTO {

    private Long organizationId;
    private String organizationName;
    private String organizationCode;
    private String status;
}
