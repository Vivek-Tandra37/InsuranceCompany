package com.vivekt.insurance.management.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vivekt.insurance.management.dto.InsurancePlanDTO;

@FeignClient(name = "PLAN-SERVICE")
public interface PlanClient {

    @GetMapping("/plans/{id}")
    InsurancePlanDTO getPlan(
            @PathVariable Long id);
}