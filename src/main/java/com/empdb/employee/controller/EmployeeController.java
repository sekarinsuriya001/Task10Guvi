package com.empdb.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.empdb.employee.model.Employee;
import com.empdb.employee.service.EmployeeService;
import java.util.List;

@Controller
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("employee",new Employee());
		return "index";
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/displayAll")
	@ResponseBody
	public List<Employee>displayAll(){
		return employeeService.getAllEmployees();
	}

	@GetMapping("/display/{employeeId}")
	@ResponseBody
	public Employee
	displayEmployee(@PathVariable String employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}
}