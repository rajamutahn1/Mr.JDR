package com.learning.Springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@NotBlank(message="Department name cannot be null")
	/*
	 * Other validations from validation starter package... internally uses hibernate validator
	 * 
	 * @Length(max=10,min=1)
	 * 
	 * @Size(max=10,min=1)
	 * 
	 * @Email
	 * 
	 * @PositiveOrZero
	 * 
	 * @FutureOrPresent
	 */
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
