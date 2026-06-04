package com.ajay.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HandlerController {

	@RequestMapping("/")
	public String showWelcomePage() {
		System.out.println("Welcome");
		return "welcome";
	}
	
}
