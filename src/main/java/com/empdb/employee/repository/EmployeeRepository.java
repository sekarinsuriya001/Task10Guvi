package com.empdb.employee.repository;

import com.empdb.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends MongoRepository<Employee,String>{
    Employee findByEmployeeId(String employeeId);
}