package com.learning.Springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Springboot.tutorial.entity.Department;
import com.learning.Springboot.tutorial.exceptions.DepartmentNotFoundException;
import com.learning.Springboot.tutorial.service.DepartmentService;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	//Logger concept starts here
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside save department method");
		return deptService.saveDepartment(department);
	}
	
	@GetMapping("departments/{deptId}")
	public Department getDepartment(@PathVariable(value = "deptId") Long deptId) throws DepartmentNotFoundException {
		LOGGER.info("Inside get department by ID method");
		return deptService.getDepartment(deptId);
	}
	
	@GetMapping("departments/all")
	public List<Department> getAllDepartments(){
		LOGGER.info("Inside get all department method");
		return deptService.getAllDepartments();
	}
	
	@DeleteMapping("departments/{id}")
	public String deleteDepartment(@PathVariable(value="id") Long deptId) {
		return deptService.deleteDepartment(deptId);
	}
	
	@PutMapping("departments/{id}")
	public Department updateDepartment(@PathVariable(value="id") Long deptId, @RequestBody Department department) {
		return deptService.updateDepartment(deptId,department);
	}
	
	@GetMapping("departments/name/{name}")
	public Department getDepartmentByName(@PathVariable(value="name") String departmentName) {
		return deptService.getDepartmentByName(departmentName);
	}
}