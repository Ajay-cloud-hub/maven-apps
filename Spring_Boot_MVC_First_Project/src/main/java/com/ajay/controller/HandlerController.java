package com.ajay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandlerController {

	@RequestMapping("/home")
	public String showWelcomePage() {
		System.out.println("Welcome");
		return "welcome";
	}
	
}
