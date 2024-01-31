package com.boot.practice.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.practice.model.Department;

public interface DepartmentDao extends CrudRepository<Department,Long> {

}
