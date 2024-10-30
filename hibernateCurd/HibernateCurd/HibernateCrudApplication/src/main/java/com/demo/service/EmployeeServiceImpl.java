package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao edao;

	public EmployeeServiceImpl() {
		
		edao=new EmployeeDaoImpl();
	}

	@Override
	public void closeMyConnection() {
		edao.closeMyConnection();
		
	}

	@Override
	public void addnewEmployee() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr employee id");
		int eid=sc.nextInt();
		System.out.println("enetr employee name");
		String ename=sc.next();
		System.out.println("enetr employee salary");
		double salary=sc.nextDouble();
		System.out.println("enetr department id");
		int deptid=sc.nextInt();
		Department d1=new Department(deptid);
		Employee e1=new Employee(eid,ename,salary,d1);
		edao.saveEmp(e1);
		
		
		
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		return edao.findAllEmp();
	}

	@Override
	public boolean deleteById(int id) {
		return edao.removeById(id);
	}

	@Override
	public boolean modifyEmployee(int id, String nm, double sal) {
		return edao.updateEmployee(id,nm,sal);
	}

	@Override
	public Employee getById(int id) {
		return edao.findById(id);
		
	}

	@Override
	public List<Employee> sortedEmployee() {
		return edao.sortByName();
	}
	
	

}
