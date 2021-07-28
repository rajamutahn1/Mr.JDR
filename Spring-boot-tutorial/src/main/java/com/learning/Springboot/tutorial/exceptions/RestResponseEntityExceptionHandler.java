package com.learning.Springboot.tutorial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.Springboot.tutorial.entity.ErrorMessage;


@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler 
			extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> departmentNotFoundException(
					DepartmentNotFoundException deptNotFoundException, WebRequest request) 
	{
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, deptNotFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);	
	}
}
