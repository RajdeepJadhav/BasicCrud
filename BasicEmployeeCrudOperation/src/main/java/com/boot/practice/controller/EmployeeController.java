package com.boot.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.practice.model.Employee;
import com.boot.practice.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eserv;

	@PostMapping("saveEmp")
	public ResponseEntity<String> saveEmployees(@RequestBody Employee emp) {
		return eserv.saveEmployee(emp);
	}
	
	@DeleteMapping("dEmp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		return eserv.deleteEmployee(id);
	}
	
	@GetMapping("getEmployeeById/{id}")
	public ResponseEntity<Object> findEmpById(@PathVariable("id") long id){
		return eserv.findEmployeeByID(id);
	}
	
	@PostMapping("updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
		return eserv.updateEmployee(emp);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return eserv.getAllEmployees();
	}
	
	
}
