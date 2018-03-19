package com.ctli.enoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctli.enoo.dao.IEmployeeAwardDAO;
import com.ctli.enoo.entity.EmployeeAward;
@Service
public class EmployeeAwardService implements IEmployeeAwardService {
	@Autowired
	private IEmployeeAwardDAO employeeAwardDAO;
	@Override
	public EmployeeAward getEmployeeAwardById(int employeeAwardId) {
		return employeeAwardDAO.getEmployeeAwardById(employeeAwardId);
	}	
	@Override
	public List<EmployeeAward> getAllEmployeeAwards(){
		return employeeAwardDAO.getAllEmployeeAwards();
	}
	@Override
	public synchronized boolean addEmployeeAward(EmployeeAward employeeAward){
       if (employeeAwardDAO.employeeAwardExists(employeeAward.getEmployee(),employeeAward.getAward())) {
    	   return false;
       } else {
    	   employeeAwardDAO.addEmployeeAward(employeeAward);
    	   return true;
       }
	}
	@Override
	public void updateEmployeeAward(EmployeeAward employeeAward) {
		employeeAwardDAO.updateEmployeeAward(employeeAward);
	}
	@Override
	public void deleteEmployeeAward(int employeeAwardId) {
		employeeAwardDAO.deleteEmployeeAward(employeeAwardId);
	}
	

}
