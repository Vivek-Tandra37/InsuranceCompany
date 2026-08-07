package com.vivekt.insurance.management.dto;

import lombok.Data;

@Data
public class InsurancePlanDTO {

    private Long planId;
    private String planName;
    private String planType;
    private Double coverageAmount;
    private Double monthlyPremium;
}
