package com.vivekt.insurance.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vivekt.insurance.management.client.EmployeeClient;
import com.vivekt.insurance.management.client.EnrollmentClient;
import com.vivekt.insurance.management.client.OrganizationClient;
import com.vivekt.insurance.management.client.PlanClient;
import com.vivekt.insurance.management.dto.EmployeeDTO;
import com.vivekt.insurance.management.dto.EmployeeEnrollmentDashboard;
import com.vivekt.insurance.management.dto.EnrollmentDTO;
import com.vivekt.insurance.management.dto.InsurancePlanDTO;
import com.vivekt.insurance.management.dto.OrganizationDTO;
import com.vivekt.insurance.management.dto.PlanSummary;

@Service
public class InsuranceManagementService {

	private final EmployeeClient employeeClient;
	private final OrganizationClient organizationClient;
	private final EnrollmentClient enrollmentClient;
	private final PlanClient planClient;

	public InsuranceManagementService(EmployeeClient employeeClient, OrganizationClient organizationClient,
			EnrollmentClient enrollmentClient, PlanClient planClient) {

		this.employeeClient = employeeClient;
		this.organizationClient = organizationClient;
		this.enrollmentClient = enrollmentClient;
		this.planClient = planClient;
	}

	public EmployeeEnrollmentDashboard getEmployeeDashboard(Long employeeId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		// Employee REST Service Call
//            ResponseEntity<EmployeeDTO> employeeResponse =
//                    restTemplate.exchange(
//                            "http://EMPLOYEE-SERVICE/employees/" + employeeId,
//                            HttpMethod.GET,
//                            requestEntity,
//                            EmployeeDTO.class);

//            Feign Client 

		EmployeeDTO employee = employeeClient.getEmployee(employeeId);

		// Organization Service Call
//            ResponseEntity<OrganizationDTO> organizationResponse =
//                    restTemplate.exchange(
//                            "http://ORGANIZATION-SERVICE/organizations/"
//                                    + employee.getOrganizationId(),
//                            HttpMethod.GET,
//                            requestEntity,	
//                            OrganizationDTO.class);

		// feign Client
		OrganizationDTO organization =

				organizationClient.getOrganization(employee.getOrganizationId());

		// Enrollment Service Call
//            ResponseEntity<List<EnrollmentDTO>> response =
//                    restTemplate.exchange(
//                            "http://ENROLLMENT-SERVICE/enrollments/employee/" + employeeId,
//                            HttpMethod.GET,
//                            requestEntity,
//                            new ParameterizedTypeReference<List<EnrollmentDTO>>() {});
//            feign Client
		List<EnrollmentDTO> enrollments = enrollmentClient.getEmployeeEnrollments(employeeId);

		List<PlanSummary> plans = new ArrayList<>();

		if (enrollments != null) {

			for (EnrollmentDTO enrollment : enrollments) {

				// Plan Service Call
//                    ResponseEntity<InsurancePlanDTO> planResponse =
//                            restTemplate.exchange(
//                                    "http://PLAN-SERVICE/plans/"
//                                            + enrollment.getPlanId(),
//                                    HttpMethod.GET,
//                                    requestEntity,
//                                    InsurancePlanDTO.class);

//                	Feign Client

				InsurancePlanDTO plan = planClient.getPlan(enrollment.getPlanId());

				if (plan != null) {

					PlanSummary planSummary = new PlanSummary();

					planSummary.setPlanId(plan.getPlanId());

					planSummary.setPlanName(plan.getPlanName());

					planSummary.setCoverageAmount(plan.getCoverageAmount());

					planSummary.setMonthlyPremium(plan.getMonthlyPremium());

					plans.add(planSummary);
				}
			}
		}

		EmployeeEnrollmentDashboard dashboard = new EmployeeEnrollmentDashboard();

		dashboard.setEmployeeId(employee.getEmployeeId());

		dashboard.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());

		dashboard.setOrganizationName(organization.getOrganizationName());

		dashboard.setEnrollments(plans);

		return dashboard;
	}
}
