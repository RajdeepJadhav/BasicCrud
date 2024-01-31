package com.boot.practice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.practice.dao.DepartmentDao;
import com.boot.practice.model.Department;
import com.boot.practice.model.Employee;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao deptDao;
	
	
	public ResponseEntity<List<Department>> getAllDepartments(){
		List<Department>li=new ArrayList<>();
		Iterator<Department>itr=deptDao.findAll().iterator();
		while(itr.hasNext()) {
			Department e=itr.next();
			li.add(e);
		}
		return new ResponseEntity<>(li,HttpStatus.OK);
		
	}

}
