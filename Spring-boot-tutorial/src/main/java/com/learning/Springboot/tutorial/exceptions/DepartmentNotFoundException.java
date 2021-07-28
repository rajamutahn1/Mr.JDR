package com.learning.Springboot.tutorial.exceptions;

public class DepartmentNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DepartmentNotFoundException() {
		super();
	} 
	
	public DepartmentNotFoundException(String message) {
		super(message);
	}
	
	public DepartmentNotFoundException(String message, Throwable clause) {
		super(message, clause);
	}
	
	public DepartmentNotFoundException(Throwable clause) {
		super(clause);
	}
}
