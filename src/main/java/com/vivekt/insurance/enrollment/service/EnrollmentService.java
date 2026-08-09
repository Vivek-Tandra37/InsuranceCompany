package com.vivekt.insurance.enrollment.service;

import java.util.List;

import com.vivekt.insurance.enrollment.entity.Enrollment;

public interface EnrollmentService {

	Enrollment save(Enrollment enrollment);

	List<Enrollment> getAll();

	Enrollment getById(Long id);

	void delete(Long id);
	
	List<Enrollment> getByEmployeeId(Long employeeId);
}