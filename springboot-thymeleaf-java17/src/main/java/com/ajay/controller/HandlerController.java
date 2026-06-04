package com.ajay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HandlerController {

    @GetMapping("/home")
    public String home() {
        return "welcome";
    }
}
