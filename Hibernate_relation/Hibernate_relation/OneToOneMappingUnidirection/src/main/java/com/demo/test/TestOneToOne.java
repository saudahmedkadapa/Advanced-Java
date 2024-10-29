package com.demo.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOne {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//save data in the table
		/*Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Faculty f=new Faculty(12,"Atharva",5);
		Course c=new Course("Java",300, f);
		session.save(f);
		session.save(c);
		tr.commit();
		session.close();
		sf.close();*/
		Session sess1=sf.openSession();
		Transaction tr11=sess1.beginTransaction();
		System.out.println("before get");
		//get is eagar fetch
		//Course course=sess1.get(Course.class,9);
		//load is lazy fetch
		Course course=sess1.load(Course.class,9);
		tr11.commit();
		System.out.println("after get");
		System.out.println(course.getCname()+"----"+course.getCourseid()+"----"+course.getDuration());
		System.out.println(course.getFac());
		sess1.close();
		sf.close();
		
		

	}

}
