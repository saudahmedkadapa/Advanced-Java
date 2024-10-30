package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.service.DepartmentService;
import com.demo.service.DepartmentServiceImpl;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestHibernateCrud {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService eservice=new EmployeeServiceImpl();
		DepartmentService dservice=new DepartmentServiceImpl();
		int choice=0;
		do {
		System.out.println("1. Add new Employee\n 2. Add new Department\n 3. delete employee\n");
		System.out.println("4. delete department\n 5. modify Department\n 6. modify employee\n");
		System.out.println("7. display Employee by id\n 8. display Department by id\n 9. display all department\n");
		System.out.println("10. display all Employee\n 11.display employee in sorted order\n12. exit\n choice : ");
		choice=sc.nextInt();
		switch (choice) {
		case 1:
			eservice.addnewEmployee();
			break;
		case 2:
			dservice.addnewDepartment();
			break;
		case 3:
			System.out.println("enter employee id for delete");
			int id=sc.nextInt();
			boolean status=eservice.deleteById(id);
			if(status) {
				System.out.println("deleted successfully");
			}else {
				System.out.println("not found");
			}
			break;
		case 4:
			System.out.println("enter department id for delete");
			id=sc.nextInt();
			status=dservice.deleteById(id);
			if(status) {
				System.out.println("deleted successfully");
			}else {
				System.out.println("not found");
			}
			break;
		case 5:
			System.out.println("enter department id for update");
			id=sc.nextInt();
			System.out.println("enetr department name");
			String nm=sc.next();
			System.out.println("enetr department loc");
			String loc=sc.next();
			status=dservice.modifyDepartment(id,nm,loc);
			if(status) {
				System.out.println("updated successfully");
			}else {
				System.out.println("not found");
			}
			break;
		case 6:
			System.out.println("enetr id for updation");
			id=sc.nextInt();
			System.out.println("enetr new namename");
			nm=sc.next();
			System.out.println("enetr new sal");
			double sal=sc.nextDouble();
			status=eservice.modifyEmployee(id,nm,sal);
			if(status) {
				System.out.println("updated successfully");
			}else {
				System.out.println("not found");
			}
			break;
		case 7:
			System.out.println("enetr employee id for display");
			id=sc.nextInt();
			Employee e=eservice.getById(id);
			if(e!=null) {
				System.out.println(e);
			}else {
				System.out.println("not found");
			}
			break;
		case 8:
			System.out.println("enetr department id for display");
			id=sc.nextInt();
			Department d=dservice.getById(id);
			if(d!=null) {
				System.out.println(d);
			}else {
				System.out.println("not found");
			}
			break;
		case 9:
			List<Department> dlist=dservice.getAllDepartment();
			dlist.forEach(System.out::println);
			break;
		case 10:
			List<Employee> elist=eservice.getAllEmployee();
			elist.forEach(System.out::println);
			break;
		case 11:
			elist=eservice.sortedEmployee();
			elist.forEach(System.out::println);
			break;
		case 12:
			eservice.closeMyConnection();
			System.out.println("Thank you for visiting .....");
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
		}while(choice!=12);

	}

}
