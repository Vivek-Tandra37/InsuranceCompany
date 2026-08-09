package com.vivekt.insurance.enrollment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vivekt.insurance.enrollment.entity.Enrollment;
import com.vivekt.insurance.enrollment.repository.EnrollmentRepository;
import com.vivekt.insurance.enrollment.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	private final EnrollmentRepository repository;

	public EnrollmentServiceImpl(EnrollmentRepository repository) {

		this.repository = repository;
	}

	@Override
	public Enrollment save(Enrollment enrollment) {

		return repository.save(enrollment);
	}

	@Override
	public List<Enrollment> getAll() {

		return repository.findAll();
	}

	@Override
	public Enrollment getById(Long id) {

		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {

		repository.deleteById(id);
	}
	
	@Override
	public List<Enrollment> getByEmployeeId(Long employeeId) {

	    return repository.findByEmployeeId(employeeId);
	}
}
