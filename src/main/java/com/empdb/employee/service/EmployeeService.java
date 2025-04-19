package com.empdb.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empdb.employee.model.Employee;
import com.empdb.employee.repository.EmployeeRepository;
import com.empdb.employee.exception.EmployeeNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee>getAllEmployees(){
		return employeeRepository.findAll();
	}

	public Employee getEmployeeByEmployeeId(String employeeId) {
		Employee employee=employeeRepository.findByEmployeeId(employeeId);
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee with ID"+employeeId+"not found");
		}
		return employee;
	}
}