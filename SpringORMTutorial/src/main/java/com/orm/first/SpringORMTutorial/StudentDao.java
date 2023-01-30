package com.orm.first.SpringORMTutorial;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public class StudentDao {
	private HibernateTemplate hiber;
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer)hiber.save(student);
		return i;
	}
	public HibernateTemplate getHiber() {
		return hiber;
	}
	public void setHiber(HibernateTemplate hiber) {
		this.hiber = hiber;
	}
	
}
