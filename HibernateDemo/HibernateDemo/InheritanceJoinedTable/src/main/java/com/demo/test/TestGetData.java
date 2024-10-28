package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.NonPerishableProduct;
import com.demo.beans.PerishableProduct;

public class TestGetData {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		PerishableProduct p1=session.get(PerishableProduct.class, 122);
		NonPerishableProduct p2=session.get(NonPerishableProduct.class, 123);
		tr.commit();
		System.out.println(p1);
		System.out.println(p2);
		session.close();
		sf.close();
		

	}

}
