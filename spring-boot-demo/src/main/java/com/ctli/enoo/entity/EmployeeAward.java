package com.ctli.enoo.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="employee_award")
public class EmployeeAward implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;  
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable=false)
    private Employee employee;
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "award_id", nullable=false)	
	private Award award;
	
	@Column(name="status")
    private String status;  
	
	@Column(name="rec_desc")
    private String RecDesc;

	@Column(name="approver_desc")
    private String approverDesc;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecDesc() {
		return RecDesc;
	}

	public void setRecDesc(String recDesc) {
		RecDesc = recDesc;
	}

	public String getApproverDesc() {
		return approverDesc;
	}

	public void setApproverDesc(String approverDesc) {
		this.approverDesc = approverDesc;
	}
	
} 