package com.vivekt.insurance.management.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vivekt.insurance.management.dto.EnrollmentDTO;

@FeignClient(name = "ENROLLMENT-SERVICE")
public interface EnrollmentClient {

    @GetMapping("/enrollments/employee/{employeeId}")
    List<EnrollmentDTO> getEmployeeEnrollments(
            @PathVariable Long employeeId);
}