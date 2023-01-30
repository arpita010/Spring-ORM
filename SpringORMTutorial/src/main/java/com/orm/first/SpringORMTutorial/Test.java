package com.orm.first.SpringORMTutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
	ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
	StudentDao dao=con.getBean("studentDao",StudentDao.class);
	Student s=new Student();
	s.setId(22);
	s.setName("aaa");
	s.setCity("meerut");
	int r=dao.insert(s);
	System.out.println(r);
}
}
