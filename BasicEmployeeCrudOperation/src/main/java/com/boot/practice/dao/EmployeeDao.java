package com.boot.practice.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.practice.model.Employee;

public interface EmployeeDao extends CrudRepository<Employee,Long> {
		
}
