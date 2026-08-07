package com.vivekt.insurance.management.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vivekt.insurance.management.dto.EmployeeDTO;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeClient {

	@GetMapping("/employees/{id}")
	EmployeeDTO getEmployee(@PathVariable Long id);
}
