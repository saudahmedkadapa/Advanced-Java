package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.beans.Product;

public class TestCriteriaQuery {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		//similar to select * from product;
		List<Product> plist=cr.list();
		plist.forEach(System.out::println);
		System.out.println("**********************");
		//select * from product where price>1000 or qty<50
		Criterion cr1=Restrictions.gt("price", 1000.00);
		Criterion cr2=Restrictions.lt("qty", 50);
		Criteria cr3=session.createCriteria(Product.class);
		LogicalExpression l1=Restrictions.and(cr1, cr2);
		cr3.add(l1);
		plist=cr3.list();
		plist.forEach(System.out::println);
		System.out.println("**********************");
		cr.setFirstResult(1);
		cr.setMaxResults(2);
		plist=cr.list();
		plist.forEach(System.out::println);
		tr.commit();
		
		

	}

}
