package com.application;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		/*
		 * press 1 for adding new employee press 2 for display all employees press 3 for
		 * get detail of single employee press 4 for updating an existing employee press
		 * 5 for delete an employee press 6 for exit.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("*********Welcome to our Spring ORM Application****************");
		System.out.println("You must follow following guidelines..");
		System.out.println("	 * press 1 for adding new employee\r\n" + "	 * press 2 for display all employees\r\n"
				+ "	 * press 3 for get detail of single employee\r\n"
				+ "	 * press 4 for updating an existing employee\r\n" + "	 * press 5 for delete an employee\r\n"
				+ "	 * press 6 for exit.");
		System.out.println("*************************************************\n\n");
		int key = -1;

		// getting beans
		ApplicationContext con = new ClassPathXmlApplicationContext("com/application/config.xml");
		EmployeeDao dao = con.getBean("dao", EmployeeDao.class);

		// application management
		do {
			System.out.println("Enter key for operation which you want to perform ?  ");
			key = sc.nextInt();
			switch (key) {
			case 1:// inserting the employee
				System.out.println("Enter data of employee ----> ");
				System.out.println("Enter Employee ID --> ");
				int eid = sc.nextInt();
				System.out.println("Enter Employee name --> ");
				String name = sc.next();
				System.out.println("Enter Employee Phone number --> ");
				String phone = sc.next();
				System.out.println("Enter Employee qualification -->");
				String quali = sc.next();
				System.out.println("Enter Employee's Department -->");
				String dept = sc.next();
				Employee emp = new Employee();
				emp.setEid(eid);
				emp.setName(name);
				emp.setPhoneNumber(phone);
				emp.setDepartment(dept);
				emp.setQualifiaction(quali);
				System.out.println(dao.insert(emp) + " record inserted successfully..");
				break;
			case 2:// display all
				List<Employee> list = dao.getAllEmployees();
				for (Employee e : list) {
					System.out.println(e);
				}
				break;
			case 3:// display single employee
				System.out.println("Enter Employee id : ");
				int id = sc.nextInt();
				Employee employee = dao.getEmployee(id);
				System.out.println("Data --> " + employee);
				break;
			case 4:// update
				Employee newEmp = new Employee();
				System.out.println("Enter Employee id of employee -->");
				newEmp.setEid(sc.nextInt());
				System.out.println("Enter new Name --> ");
				newEmp.setName(sc.nextLine());
				System.out.println("Enter new Department-->");
				newEmp.setDepartment(sc.nextLine());
				System.out.println("Enter Qualification : ");
				newEmp.setQualifiaction(sc.nextLine());
				System.out.println("Enter new Phone number -->");
				newEmp.setPhoneNumber(sc.nextLine());
				dao.update(newEmp);
				break;
			case 5:// delete
				System.out.println("Enter employee id for deletion -->");
				dao.delete(sc.nextInt());
				break;
			case 6:// exit
				break;
			default:
				System.out.println("Invalid choice!Enter again!!");
			}
		} while (key != 6);
		System.out.println("Thanks for using our application!");
		System.out.println("Hope you like our efforts !!!!");
	}
}
