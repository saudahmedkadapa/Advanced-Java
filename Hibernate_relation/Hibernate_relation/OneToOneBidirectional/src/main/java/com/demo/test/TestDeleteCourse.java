package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Faculty;

public class TestDeleteCourse {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//save data in the table
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Faculty f=session.get(Faculty.class, 12);
		//Faculty f1=session.get(Faculty.class, 13);
		//f1.setFacid(131);
		//session.update(f1);
		System.out.println(f);
		session.delete(f);
		tr.commit();
		session.close();
		sf.close();
	}
	
}
