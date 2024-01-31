package com.boot.practice.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.practice.dao.EmployeeDao;
import com.boot.practice.model.Employee;

@Service
public class EmployeeService implements EmployeeInterfaceService {

	@Autowired
	private EmployeeDao edao;

	public ResponseEntity<String> saveEmployee(Employee emp) {
		if (emp != null) {
			edao.save(emp);
			return new ResponseEntity<>("Employee saved successFully!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee data is abscent!!", HttpStatus.OK);
		}
	}

	public ResponseEntity<String> deleteEmployee(long id) {

		Optional<Employee> opt = edao.findById(id);
		if (!opt.isEmpty()) {
			edao.deleteById(id);
			return new ResponseEntity<>("Employee with id " + id + " delete successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee with id " + id + " not found or doesn't exist", HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> findEmployeeByID(long id){
		if(id>0) {
		Optional<Employee> opt=edao.findById(id);
		if(!opt.isEmpty()) {
			Employee es=opt.get();
			return new ResponseEntity<>(es,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No such employee with id : "+id,HttpStatus.OK);
		}
		}
		else {
			 return new ResponseEntity<>("No such employee with id : "+id,HttpStatus.OK);
		}
	}

	public ResponseEntity<String> updateEmployee(Employee e) {
		if (e != null) {
			Optional<Employee> opt = edao.findById(e.getEmpId());
			if (!opt.isEmpty()) {
				edao.save(e);
				return new ResponseEntity<>("Employee updated successfully!! ", HttpStatus.OK);

			} else {
				return new ResponseEntity<>("No such employee exist in database ! ", HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>("No such employee exist in database ! ", HttpStatus.OK);
		}
	}

	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> li = new LinkedList<>();
		Iterator<Employee> itr = edao.findAll().iterator();
		while (itr.hasNext()) {
			Employee e = itr.next();
			li.add(e);
		}
		return new ResponseEntity<>(li, HttpStatus.OK);
	}

}
