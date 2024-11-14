package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class TestUpdate {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		//retrieve data in the RAM
		//p is in persistent state
		Product p=session.get(Product.class, 2);
		p.setPname("yyyyy");
		//since p is only in persistent state, so both merge or update will work fine
		session.update(p);
		//session.merge(p);
		tr.commit();
		session.close();
		sf.close();

	}

}
