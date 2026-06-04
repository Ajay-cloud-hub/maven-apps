package com.ajay._4.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.ajay._2.entity.Employee;

public interface EmployeeManagementService {
	public List<Employee> fetchAllEmployees();
	public String deleteRecordById(int id);
	public String updateRecordById(Employee emp,int id);
	
	public String saveEmployee(Employee employee);
	
	public List<Employee> showEmployeeDynamicSearch(Employee emp);
}
