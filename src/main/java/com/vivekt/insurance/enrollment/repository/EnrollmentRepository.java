package com.vivekt.insurance.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivekt.insurance.enrollment.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	
	List<Enrollment> findByEmployeeId(Long empId);

}
