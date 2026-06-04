package com.ajay._3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajay._2.entity.Employee;
import com.ajay._4.service.EmployeeManagementService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private EmployeeManagementService empService;

	@GetMapping("/")
	public String showWelcomePage() {
		System.out.println("showWelcomePage()");
		return "welcome";
	}

	// Get mode(G)
	@GetMapping("/report")
	public String getAllEmployees(@ModelAttribute("emp") Employee emp,Map<String, Object> map) {
		List<Employee> employeesList = empService.fetchAllEmployees();
		map.put("listOfEmployees", employeesList);
		return "show_emps_data";
	}

	//================ Deletion without using Redirection =============
	
//	@GetMapping("/delete")
//	public String removeRecordById(@RequestParam("empno") int no, Map<String,Object> map) {
//		String returnMsg = empService.deleteRecordById(no);
//		attrs.addFlashAttribute("returnMsg",returnMsg);
//		map.put("returnMsg", returnMsg);
//		return "delete_result";
//	}

	//================ Deletion using Redirection =============
	@GetMapping("/delete")
	public String removeRecordById(@RequestParam("empno") int no, RedirectAttributes attrs ) {
		String returnMsg = empService.deleteRecordById(no);
		attrs.addFlashAttribute("returnMsg",returnMsg);
		return "redirect:report";
	}
	
	@GetMapping("/update")
	public void editEmployeeById(@RequestParam("no") Employee empFromReq,
			@ModelAttribute("empData") Employee empToForm) {
		int empno = empFromReq.getEmpno();
		empToForm.setEmpno(empno);
		String empname = empFromReq.getEmpname();
		empToForm.setEmpname(empname);
		String job = empFromReq.getJob();
		empToForm.setJob(job);
		Double sal = empFromReq.getSal();
		empToForm.setSal(sal);
		Integer deptno = empFromReq.getDeptno();
		empToForm.setDeptno(deptno);
	}

	@PostMapping("/update")
	public String editEmployeeByFormById(@ModelAttribute("empData") Employee emp, RedirectAttributes attrs /*Model model*/) {
		try {
			//model.addAttribute("emp", List.of(emp));
			String returnMsg = empService.updateRecordById(emp, emp.getEmpno());
//			model.addAttribute("returnMsg",returnMsg);
//			return "update_result";
			attrs.addFlashAttribute("returnMsg",returnMsg);
			return "redirect:report";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@GetMapping("/register")
	public String registerEmployee(@ModelAttribute("emp") Employee employee) {
		return "add_employee";
	}

	// without PRG pattern
//	@PostMapping("/register")
//	public String registerEmployeeByPost(@ModelAttribute("emp") Employee employee, Map<String, Object> map) {
//		String returnMsg = empService.saveEmployee(employee);
//		List<Employee> fetchAllEmployees = empService.fetchAllEmployees();
//		map.put("listOfEmployees", List.of(fetchAllEmployees));
//		map.put("returnMsg", returnMsg);
//		return "show_emps_data";
//	}

	// with PRG pattern, with out Shared Memory(RedirectAttributes).
	// Post mode(P)
//	@PostMapping("/register")
//	public String registerEmployeeByPost(@ModelAttribute("emp") Employee employee, Map<String, Object> map) {
//		String returnMsg = empService.saveEmployee(employee);
//		map.put("returnMsg", returnMsg);
//		return "redirect:report"; // redirect mode(R)
//	}

	// with PRG pattern, with Shared Memory(RedirectAttributes).
		// Post mode(P)
	@PostMapping("/register")
	public String registerEmployeeByPost(@ModelAttribute("emp") Employee employee, RedirectAttributes attrs) {
		String returnMsg = empService.saveEmployee(employee);
		attrs.addFlashAttribute("returnMsg", returnMsg);
		return "redirect:report"; // redirect mode(R)
	}
	
	@PostMapping("/search")
	public String showDynamicSearchEmp(@ModelAttribute("emp") Employee emp, Map<String,Object> map) {
		List<Employee> listOfEmployeeDynamicSearch = empService.showEmployeeDynamicSearch(emp);
		map.put("listOfEmployees", listOfEmployeeDynamicSearch);
		return "show_emps_data";
	}
}
