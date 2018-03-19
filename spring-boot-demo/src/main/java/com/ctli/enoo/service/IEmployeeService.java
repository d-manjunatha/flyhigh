package com.ctli.enoo.service;

import java.util.List;

import com.ctli.enoo.entity.Employee;

public interface IEmployeeService {
     List<Employee> getAllEmployees();
     Employee getEmployeeById(int EmployeeId);
     boolean addEmployee(Employee Employee);
     void updateEmployee(Employee Employee);
     void deleteEmployee(int EmployeeId);

}
