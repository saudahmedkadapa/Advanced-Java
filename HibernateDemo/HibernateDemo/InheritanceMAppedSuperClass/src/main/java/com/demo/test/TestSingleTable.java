package com.demo.test;



import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.NonPerishableProduct;
import com.demo.beans.PerishableProduct;

public class TestSingleTable {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		PerishableProduct p1=new PerishableProduct(122,"Apple",LocalDate.of(2023, 12,12 ),LocalDate.of(2024, 12,12));
		NonPerishableProduct p2=new NonPerishableProduct(123,"chair",LocalDate.of(2023, 12,12 ),"furniture");
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
		

	}

}

