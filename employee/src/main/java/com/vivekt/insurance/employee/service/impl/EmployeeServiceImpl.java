package com.vivekt.insurance.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vivekt.insurance.employee.entity.Employee;
import com.vivekt.insurance.employee.repository.EmployeeRepository;
import com.vivekt.insurance.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return repository.findAll();
	}

	@Override
	public Employee getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Employee update(Long id, Employee employee) {

		Employee existing = repository.findById(id).orElse(null);

		existing.setEmployeeNumber(employee.getEmployeeNumber());

		existing.setFirstName(employee.getFirstName());

		existing.setLastName(employee.getLastName());

		existing.setEmail(employee.getEmail());

		existing.setOrganizationId(employee.getOrganizationId());

		existing.setStatus(employee.getStatus());

		return repository.save(existing);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
