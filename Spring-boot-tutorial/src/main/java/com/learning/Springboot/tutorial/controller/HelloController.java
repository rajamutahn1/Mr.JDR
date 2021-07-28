package com.learning.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	//Value fetched from application.properties file.
	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/")
	public String helloWorld() {
		return message;
	}
}
