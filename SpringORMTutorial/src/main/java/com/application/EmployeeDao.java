package com.application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class EmployeeDao {
	private HibernateTemplate temp;
	@Transactional
	public int insert(Employee emp)
	{
		temp.save(emp);
		return 1;
	}
	public HibernateTemplate getTemp() {
		return temp;
	}
	public void setTemp(HibernateTemplate temp) {
		this.temp = temp;
	}
	@Transactional
	public void update(Employee emp)
	{
		temp.update(emp);
		System.out.println("Employee updated successfully...");
	}
	public void delete(int eid)
	{
		Employee emp=temp.get(Employee.class,eid);
		temp.delete(emp);
		System.out.println("Deleted successfully...");
	}
	public Employee getEmployee(int eid)
	{
		Employee emp=temp.get(Employee.class, eid);
		return emp;
	}
	public List<Employee> getAllEmployees()
	{
		List<Employee> list=temp.loadAll(Employee.class);
		return list;
	}
}
