package com.boot.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.practice.model.Department;
import com.boot.practice.service.DepartmentService;

@RestController
@RequestMapping("/Department")
@CrossOrigin(origins="http://localhost:3000")
public class DepartmentController {

	@Autowired
	private DepartmentService dService;
	
	@GetMapping("/allDepartments")
	public ResponseEntity<List<Department>> getAllDepartments(){
		
		return dService.getAllDepartments();
	}
}
