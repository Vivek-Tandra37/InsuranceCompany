package com.vivekt.insurance.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vivekt.insurance.employee.entity.Employee;
import com.vivekt.insurance.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping
	public Employee createEmployee(@Valid @RequestBody Employee employee) {

		return employeeService.save(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {

		return employeeService.getAll();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {

		return employeeService.getById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

		return employeeService.update(id, employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {

		employeeService.delete(id);
		return "Employee deleted successfully";
	}
}
