package com.ctli.enoo.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctli.enoo.entity.Award;
import com.ctli.enoo.entity.Employee;
import com.ctli.enoo.entity.EmployeeAward;
@Transactional
@Repository
public class EmployeeAwardDAO implements IEmployeeAwardDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public EmployeeAward getEmployeeAwardById(int employeeAwardId) {
		return entityManager.find(EmployeeAward.class, employeeAwardId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeAward> getAllEmployeeAwards() {
		String hql = "FROM EmployeeAward as atcl ORDER BY atcl.employeeAwardId";
		return (List<EmployeeAward>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addEmployeeAward(EmployeeAward employeeAward) {
		entityManager.persist(employeeAward);
	}
	@Override
	public void updateEmployeeAward(EmployeeAward employeeAward) {
		EmployeeAward e = getEmployeeAwardById(employeeAward.getId());
		e.setRecDesc(employeeAward.getRecDesc());
		e.setApproverDesc(employeeAward.getApproverDesc());
		entityManager.flush();
	}
	@Override
	public void deleteEmployeeAward(int employeeAwardId) {
		entityManager.remove(getEmployeeAwardById(employeeAwardId));
	}
	@Override
	public boolean employeeAwardExists(Employee employee, Award award) {
		String hql = "FROM EmployeeAward WHERE employee = ? and award = ?";
		int count = entityManager.createQuery(hql).setParameter(1, employee)
					.setParameter(2, award)
		            .getResultList().size();
		return count > 0 ? true : false;
	}
}
