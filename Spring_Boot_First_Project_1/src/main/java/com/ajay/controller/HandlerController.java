package com.ajay.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HandlerController {

	@RequestMapping("/home")
	public String showWelcomePage() {
		System.out.println("Welcome");
		return "welcome";
	}
	
}
