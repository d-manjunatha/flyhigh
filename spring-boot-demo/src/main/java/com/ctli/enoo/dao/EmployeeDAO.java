package com.ctli.enoo.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctli.enoo.entity.Employee;
@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String hql = "FROM Employee as atcl ORDER BY atcl.id";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	@Override
	public void updateEmployee(Employee employee) {
		Employee e = getEmployeeById(employee.getId());
		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		entityManager.flush();
	}
	@Override
	public void deleteEmployee(int employeeId) {
		entityManager.remove(getEmployeeById(employeeId));
	}
	@Override
	public boolean employeeExists(String email) {
		String hql = "FROM Employee WHERE email = ?";
		int count = entityManager.createQuery(hql).setParameter(1, email)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
