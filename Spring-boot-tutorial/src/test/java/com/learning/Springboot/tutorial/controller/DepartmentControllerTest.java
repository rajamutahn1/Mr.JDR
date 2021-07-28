package com.learning.Springboot.tutorial.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.learning.Springboot.tutorial.entity.Department;
import com.learning.Springboot.tutorial.exceptions.DepartmentNotFoundException;
import com.learning.Springboot.tutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService deptService;

	private Department dept;
	
	@BeforeEach
	void setUp() throws Exception {
		dept = Department.builder()
				.departmentAddress("Chennai")
				.departmentCode("MECH-01")
				.departmentName("Mechanical")
				.departmentId(1L)
				.build();
	}

	@Test
	@DisplayName("Save Department from controller")
	public void whenSaveDepartment_thenReturnDepartment() throws Exception {
		Department inputDepartment = Department.builder()
				.departmentAddress("Chennai")
				.departmentCode("MECH-01")
				.departmentName("Mechanical")
				.build();
		Mockito.when(deptService.saveDepartment(inputDepartment)).thenReturn(dept);
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "	\"departmentName\":\"Mechanical\",\r\n"
						+ "	\"departmentAddress\":\"Chennai\",\r\n"
						+ "	\"departmentCode\":\"MECH-01\"\r\n"
						+ "}"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@DisplayName("Fetch Department by using Id from controller")
	public void whenGetDepartmentById_thenReturnDepartment() throws Exception {
		Mockito.when(deptService.getDepartment(1L)).thenReturn(dept);
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
			//.andExpect(jsonPath("$.departmentName").value(dept.getDepartmentName()));
	}
}
