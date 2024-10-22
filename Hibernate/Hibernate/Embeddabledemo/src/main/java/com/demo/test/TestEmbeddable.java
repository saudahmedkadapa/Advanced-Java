package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.MyUser;

public class TestEmbeddable {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Address a1=new Address("aundh","pune","Maharashtra");
		MyUser u1=new MyUser(13,"Revati","5555",a1);
		Address a2=new Address("kothrud","pune","Maharashtra");
		MyUser u2=new MyUser(14,"Sangeeta","44444",a2);
		session.save(u1);
		session.save(u2);
		tr.commit();
		session.close();
		sf.close();
		
		

	}

}
