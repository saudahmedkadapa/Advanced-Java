package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class DepartmentDaoImpl implements DepartmentDao {
	static SessionFactory sf;
	static {
		sf=HBUtil.getMySessionFactory();
	}
	@Override
	public void save(Department d) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(d);
		tr.commit();
		session.close();
		
	}
	@Override
	public boolean removeById(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Department dept=session.get(Department.class,id);
		System.out.println(dept);
		if(dept!=null) {
			//delete the employee
			session.delete(dept);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	@Override
	public boolean updateById(int id, String nm, String loc) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Department dept=session.get(Department.class,id);
		if(dept!=null) {
		    dept.setDname(nm);
		    dept.setDloc(loc);
		    tr.commit();
		    session.close();
		    return true;
		    
		}
		session.close();
		return false;
	}
	@Override
	public Department findById(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Department dept=session.load(Department.class,id);
		return dept;
	}
	@Override
	public List<Department> findAll() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query q=session.createQuery("from Department ");
		List<Department> dlist=q.list();
		return dlist;
	}
	
}
