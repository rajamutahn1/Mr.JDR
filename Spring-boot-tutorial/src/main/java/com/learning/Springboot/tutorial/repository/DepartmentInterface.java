package com.learning.Springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.Springboot.tutorial.entity.Department;

@Repository
public interface DepartmentInterface extends JpaRepository<Department,Long>
{

	public Department findByDepartmentNameIgnoreCase(String departmentName);
}
