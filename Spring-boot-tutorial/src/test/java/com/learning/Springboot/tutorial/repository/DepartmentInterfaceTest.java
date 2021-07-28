package com.learning.Springboot.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.learning.Springboot.tutorial.entity.Department;

@DataJpaTest
class DepartmentInterfaceTest {
	
	@Autowired
	private DepartmentInterface deptRepository;

	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.departmentName("Mechanical")
				.departmentAddress("Chennai")
				.departmentCode("MECH-01")
				.build();
		entityManager.persist(department);
	}
	
	@Test
	@DisplayName("Get department by Id")
	public void whenFindByID_thenReturnDepartment() {
		Department department = deptRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(),"Mechanical");
	}
}