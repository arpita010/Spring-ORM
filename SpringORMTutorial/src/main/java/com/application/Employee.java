package com.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class Employee {
	@Id
	@Column(name = "EmployeeId")
	private int eid;
	@Column(name = "EmployeeName")
	private String name;
	@Column(name = "ContactInfo")
	private String phoneNumber;
	@Column(name = "Qualification")
	private String qualifiaction;
	@Column(name="Department")
	private String department;

	public int getEid() {
		return eid;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getQualifiaction() {
		return qualifiaction;
	}

	public String getDepartment() {
		return department;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setQualifiaction(String qualifiaction) {
		this.qualifiaction = qualifiaction;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", phoneNumber=" + phoneNumber + ", qualifiaction="
				+ qualifiaction + ", department=" + department + "]";
	}

}
