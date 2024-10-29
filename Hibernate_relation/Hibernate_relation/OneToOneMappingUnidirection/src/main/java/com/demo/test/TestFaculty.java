package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Faculty;

public class TestFaculty {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//save data in the table
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Faculty f=session.get(Faculty.class, 12);
		System.out.println(f);
		
	}

}
