package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;

public class TestUpdateandmergeProduct {

	public static void main(String[] args) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Transaction tr=session.beginTransaction();
	//retrieve data in the RAM
	Product p=session.get(Product.class, 2);
	session.close();
	//p is modified in detached state
	p.setPname("yyyyy");
	
	Session sess1=sf.openSession();
	Transaction tr1=sess1.beginTransaction();
	//p1 is in persistent state but id of p and p1 is same, 
	//so here update will not work
	Product p1=sess1.get(Product.class, 2);
	//this throws exception NonuiqueObjectException 
	//sess1.update(p);
	sess1.merge(p);
	tr1.commit();
	sess1.close();
	sf.close();
	

	}

}
