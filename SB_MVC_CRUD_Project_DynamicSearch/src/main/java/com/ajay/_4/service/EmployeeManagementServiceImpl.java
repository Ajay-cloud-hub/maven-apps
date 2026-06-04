package com.ajay._4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ajay._2.entity.Employee;
import com.ajay._5.repository.EmployeeRepository;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> fetchAllEmployees() {
		List<Employee> list = empRepo.findAll();
		list.sort((emp1, emp2) -> emp1.getEmpname().compareTo(emp2.getEmpname()));
		return list;
	}

	@Override
	public String deleteRecordById(int id) {
		Optional<Employee> opt = empRepo.findById(id);
		if (opt.isPresent()) {
			empRepo.deleteById(id);
		}else {
			throw new IllegalArgumentException("Record Not Found");
		}
		return "Employee is deleted with "+id;
	}

	@Override
	public String updateRecordById(Employee emp,int id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isPresent()) {
			empRepo.save(emp);
		}
		
		return "Employee is updated with "+id;
	}

	@Override
	public String saveEmployee(Employee employee) {
		Employee save = empRepo.save(employee);
		return "Employee is saved with "+save.getEmpno();
	}

	@Override
	public List<Employee> showEmployeeDynamicSearch(Employee emp) {
		//Here Only make the null value for the String type only
		if(emp.getEmpname().equalsIgnoreCase("")||emp.getEmpname().length()==0) 
			emp.setEmpname(null);
		if(emp.getJob().equalsIgnoreCase("")||emp.getJob().length()==0)
			emp.setJob(null);
//		if(emp.getSal().equals("")||emp.getSal()==0)
//			emp.setSal(null);
//		if(emp.getDeptno().equals("")|| emp.getDeptno()==0)
//			emp.setDeptno(null);
		// prepare Example object
		Example<Employee> example = Example.of(emp);
		List<Employee> list = empRepo.findAll(example);
		return list;
	}

}


















