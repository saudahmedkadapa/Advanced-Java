package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public class TestManyToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e1=new Employee(12,"Swati",34567,null);
		Employee e2=new Employee(13,"Arati",44445,null);
		Employee e3=new Employee(14,"Sujay",22222,null);
		Employee e4=new Employee(15,"Sushant",55555,null);
		Set<Employee> set1=new HashSet<>();
		Set<Employee> set2=new HashSet<>();
		set1.add(e1);
		set1.add(e2);
		set2.add(e3);
		set2.add(e4);
		set2.add(e1);
		
		Project p1=new Project(100,"Loan",345,set1);
		Project p2=new Project(101,"Inssurance",500,set2);
		Set<Project> pset1=new HashSet<>();
		Set<Project> pset2=new HashSet<>();
		Set<Project> pset3=new HashSet<>();
		pset1.add(p1);
		pset2.add(p2);
		pset3.add(p1);
		pset3.add(p2);
		e2.setPset(pset1);
		e3.setPset(pset2);
		e4.setPset(pset2);
		e1.setPset(pset3);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
		
		

	}

}
