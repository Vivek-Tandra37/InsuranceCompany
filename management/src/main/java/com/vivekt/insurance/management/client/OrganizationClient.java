package com.vivekt.insurance.management.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vivekt.insurance.management.dto.OrganizationDTO;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationClient {

    @GetMapping("/organizations/{id}")
    OrganizationDTO getOrganization(
            @PathVariable Long id);
}