package com.ajay._5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajay._2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
