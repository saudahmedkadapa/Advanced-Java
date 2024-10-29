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
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Faculty f=new Faculty(14,"Rajan",5,null);
		Course c=new Course("devops",100, f);
		f.setC(c);
		session.save(f);
		session.save(c);
		tr.commit();
		session.close();
		
		Session sess1=sf.openSession();
		Transaction tr11=sess1.beginTransaction();
		System.out.println("before get");
		//get is eagar fetch
		//Course course=sess1.get(Course.class,9);
		//load is lazy fetch
		Course course=sess1.load(Course.class,9);
		Faculty f1=sess1.get(Faculty.class, 13);
		tr11.commit();
		System.out.println("after get");
		System.out.println(course.getCname()+"----"+course.getCourseid()+"----"+course.getDuration());
		System.out.println(course.getFac());
		System.out.println(f1);
		System.out.println(f1.getC().getCname()+"-----"+f1.getC().getDuration());
		sess1.close();
		sf.close();
		
		

	}

}
