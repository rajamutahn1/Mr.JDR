package com.learning.Springboot.tutorial.service;

import java.util.List;

import com.learning.Springboot.tutorial.entity.Department;
import com.learning.Springboot.tutorial.exceptions.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public Department getDepartment(Long id) throws DepartmentNotFoundException;

	public List<Department> getAllDepartments();

	public String deleteDepartment(Long deptId);

	public Department updateDepartment(Long deptId, Department department);

	public Department getDepartmentByName(String departmentName);

}
