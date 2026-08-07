package com.vivekt.insurance.management.dto;

import lombok.Data;

@Data

public class PlanSummary {

private Long planId;

private String planName;

private Double coverageAmount;

private Double monthlyPremium;

}