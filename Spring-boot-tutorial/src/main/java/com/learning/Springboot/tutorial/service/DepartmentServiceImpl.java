package com.learning.Springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.Springboot.tutorial.entity.Department;
import com.learning.Springboot.tutorial.exceptions.DepartmentNotFoundException;
import com.learning.Springboot.tutorial.repository.DepartmentInterface;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentInterface deptRepo;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptRepo.save(department);
	}

	@Override
	public Department getDepartment(Long id) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department = deptRepo.findById(id);
		
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Oops..! No Department is available for the id.");
		}
		
		return department.get();
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	@Override
	public String deleteDepartment(Long deptId) {
		// TODO Auto-generated method stub
		deptRepo.deleteById(deptId);
		return "Deleted successfully";
	}

	@Override
	public Department updateDepartment(Long deptId, Department department) {
		// TODO Auto-generated method stub
		Department dept = deptRepo.findById(deptId).get();
		
		if(Objects.nonNull(department.getDepartmentName())
				&& !department.getDepartmentName().isBlank()
				&& !department.getDepartmentName().isEmpty()) {
			dept.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress())
				&& !department.getDepartmentAddress().isBlank()
				&& !department.getDepartmentAddress().isEmpty()) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode())
				&& !department.getDepartmentCode().isBlank()
				&& !department.getDepartmentCode().isEmpty()) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		
		return dept;
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return deptRepo.findByDepartmentNameIgnoreCase(departmentName);
	}
}
