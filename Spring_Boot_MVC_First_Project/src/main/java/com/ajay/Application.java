package com.ajay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class Application {

//	@Bean
//	public RequestMappingHandlerMapping irvr() {
//		return new RequestMappingHandlerMapping();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
