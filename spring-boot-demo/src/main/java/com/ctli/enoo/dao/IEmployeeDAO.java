package com.ctli.enoo.dao;
import java.util.List;

import com.ctli.enoo.entity.Employee;
public interface IEmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeId);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    boolean employeeExists(String email);
}
 