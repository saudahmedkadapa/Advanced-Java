package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e1=new Employee(12,"Rajas",34566,null);
		Employee e2=new Employee(13,"Devendra",45678,null);
		Employee e3=new Employee(14,"Rashmi",45678,null);
		Employee e4=new Employee(15,"Rohit",55678,null);
		Set<Employee> set1=new HashSet<>();
		Set<Employee> set2=new HashSet<>();
		set1.add(e1);
		set1.add(e2);
		set2.add(e3);
		set2.add(e4);
		Department d1=new Department(1,"Admin","Pune",set1);
		Department d2=new Department(2,"HR","Mumbai",set2);
		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d2);
		e4.setDept(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(d1);
		session.save(d2);
		tr.commit();
		session.close();
		sf.close();

	}

}
