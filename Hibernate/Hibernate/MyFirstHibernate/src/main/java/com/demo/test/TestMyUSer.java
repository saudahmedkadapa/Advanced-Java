package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;
import com.demo.beans.Product;

public class TestMyUSer {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		//MyUser u=new MyUser(124,"xxx","x@gmail.com","2333");
		//MyUser u1=new MyUser(134,"yyyy","yy@gmail.com","345345");
		//Product p=new Product("chair22",45,3456);
		//Product p1=new Product("stool22",12,2000);
		
		//sess.save(u);
		//sess.save(u1);
		//sess.save(p1);
		///sess.save(p);
		
		//tr.commit();
		//sess.close();
		//retrieve the value
		Session sess1=sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		System.out.println("before get");
		//egar fetch will fetch actual data as soon as get method is called 
		//Product p2=sess1.get(Product.class, 2);  //egar fetch
		//lazy fetch will fetch the data if you call any getter method on p2
		Product p2=sess1.load(Product.class, 2);  //lazy fetch
		System.out.println("after get");
		System.out.println(p2.getPname()+"----"+p2.getQty());
		sf.close();
		

	}

}
