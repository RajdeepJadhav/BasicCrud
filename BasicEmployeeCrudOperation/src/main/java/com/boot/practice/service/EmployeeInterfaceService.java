package com.boot.practice.service;

import org.springframework.http.ResponseEntity;

import com.boot.practice.model.Employee;

public interface EmployeeInterfaceService {

	
	ResponseEntity<String> saveEmployee(Employee emp);
}
