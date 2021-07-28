package com.learning.Springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.learning.Springboot.tutorial.entity.Department;
import com.learning.Springboot.tutorial.repository.DepartmentInterface;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService deptServ;
	
	@MockBean
	private DepartmentInterface	depRepo;
	
	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Chennai")
				.departmentCode("IT-07")
				.departmentId(1L)
				.build();
		Mockito.when(depRepo.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);	
	}

	@Test
	@DisplayName("Get department by using name: Positive Scenario")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String deptName = "IT";
		Department found = deptServ.getDepartmentByName(deptName);
		assertEquals(deptName,found.getDepartmentName());
	}
}
