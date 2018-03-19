package com.ctli.enoo.dao;
import java.util.List;

import com.ctli.enoo.entity.Award;
import com.ctli.enoo.entity.Employee;
import com.ctli.enoo.entity.EmployeeAward;
public interface IEmployeeAwardDAO {
    List<EmployeeAward> getAllEmployeeAwards();
    EmployeeAward getEmployeeAwardById(int employeeAwardId);
    void addEmployeeAward(EmployeeAward employeeAward);
    void updateEmployeeAward(EmployeeAward employeeAward);
    void deleteEmployeeAward(int employeeAwardId);
	boolean employeeAwardExists(Employee employee, Award award);
}
 