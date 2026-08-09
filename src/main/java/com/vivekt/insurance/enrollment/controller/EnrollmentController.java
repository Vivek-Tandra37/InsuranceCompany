package com.vivekt.insurance.enrollment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vivekt.insurance.enrollment.entity.Enrollment;
import com.vivekt.insurance.enrollment.service.EnrollmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

	private final EnrollmentService enrollmentService;

	public EnrollmentController(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	@PostMapping
	public ResponseEntity<Enrollment> createEnrollment(@Valid @RequestBody Enrollment enrollment) {

		Enrollment savedEnrollment = enrollmentService.save(enrollment);

		return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Enrollment>> getAllEnrollments() {

		return ResponseEntity.ok(enrollmentService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {

		Enrollment enrollment = enrollmentService.getById(id);

		if (enrollment == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(enrollment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEnrollment(@PathVariable Long id) {

		Enrollment enrollment = enrollmentService.getById(id);

		if (enrollment == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enrollment not found");
		}

		enrollmentService.delete(id);

		return ResponseEntity.ok("Enrollment deleted successfully");
	}
	
	@GetMapping("/employee/{employeeId}")
	public List<Enrollment> getEmployeeEnrollments(
	        @PathVariable Long employeeId) {

	    return enrollmentService
	            .getByEmployeeId(employeeId);
	}
}
