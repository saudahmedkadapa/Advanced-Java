package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.dao.DepartmentDao;
import com.demo.dao.DepartmentDaoImpl;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao ddao;

	public DepartmentServiceImpl() {
		
		ddao=new DepartmentDaoImpl();
	}

	@Override
	public void addnewDepartment() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int deptid=sc.nextInt();
		System.out.println("Enter name");
		String dname=sc.next();
		System.out.println("Enter location");
		String dloc=sc.next();
		Department d=new Department(deptid,dname,dloc,null);
		ddao.save(d);
		
	}

	@Override
	public boolean deleteById(int id) {
		return ddao.removeById(id);
	}

	@Override
	public boolean modifyDepartment(int id, String nm, String loc) {
		return ddao.updateById(id,nm,loc);
	}

	@Override
	public Department getById(int id) {
		return ddao.findById(id);
	}

	@Override
	public List<Department> getAllDepartment() {
		return ddao.findAll();
	}
}
