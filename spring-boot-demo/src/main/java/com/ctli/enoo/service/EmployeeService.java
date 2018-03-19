package com.ctli.enoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctli.enoo.dao.IEmployeeDAO;
import com.ctli.enoo.entity.Employee;
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDAO employeeDAO;
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeDAO.getEmployeeById(employeeId);
	}	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeDAO.getAllEmployees();
	}
	@Override
	public synchronized boolean addEmployee(Employee employee){
       if (employeeDAO.employeeExists(employee.getEmail())) {
    	   return false;
       } else {
    	   employeeDAO.addEmployee(employee);
    	   return true;
       }
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}
	@Override
	public void deleteEmployee(int employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}
	

}
