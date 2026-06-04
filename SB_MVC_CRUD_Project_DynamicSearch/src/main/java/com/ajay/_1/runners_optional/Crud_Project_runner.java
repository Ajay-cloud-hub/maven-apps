package com.ajay._1.runners_optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ajay._2.entity.Employee;
import com.ajay._3.controller.EmployeeOperationsController;

//@Component()
public class Crud_Project_runner implements CommandLineRunner {
	@Autowired
	private EmployeeOperationsController controller;

	@Override
	public void run(String... args) throws Exception {
//		List<Employee> allEmployees = controller.getAllEmployees();
//		allEmployees.forEach(emp -> {
//			System.out.println(emp.getEmpno() + " " + emp.getEmpname() + " " + emp.getJob() + " " + emp.getSal() + " "
//					+ emp.getDeptno());
//		});
		
	}

}
