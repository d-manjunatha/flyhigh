package com.ctli.enoo.service;

import java.util.List;

import com.ctli.enoo.entity.EmployeeAward;

public interface IEmployeeAwardService {
     List<EmployeeAward> getAllEmployeeAwards();
     EmployeeAward getEmployeeAwardById(int employeeAwardId);
     boolean addEmployeeAward(EmployeeAward employeeAward);
     void updateEmployeeAward(EmployeeAward employeeAward);
     void deleteEmployeeAward(int employeeAwardId);

}
