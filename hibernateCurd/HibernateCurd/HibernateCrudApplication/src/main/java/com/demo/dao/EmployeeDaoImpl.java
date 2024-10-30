package com.demo.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	static SessionFactory sf;
	static {
		sf=HBUtil.getMySessionFactory();
	}
	@Override
	public void closeMyConnection() {
		HBUtil.closeMyConnection();
		
	}
	@Override
	public void saveEmp(Employee e1) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(e1);
		//this will search department based on ID
		Department d=session.load(Department.class, e1.getDept().getDeptno());
		//retrieve the data based on name
		//String dnm=e1.getDept().getDname();
		//Query q=session.createQuery("select p from Department d1 where p.dname=dnm");
		//Department d2=(Department) q.getSingleResult()
		e1.setDept(d);
		session.saveOrUpdate(e1);
		tr.commit();
		session.close();
		System.out.println("data svaed");
		
		
	}
	@Override
	public List<Employee> findAllEmp() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Employee");
		List<Employee> elist=query.list();
		tr.commit();
		session.close();
		return elist;
	}
	@Override
	public boolean removeById(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null) {
			//delete the employee
			session.delete(emp);
			tr.commit();
			session.close();
			return true;
		}
		return false;
	}
	@Override
	public boolean updateEmployee(int id, String nm, double sal) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null) {
			//delete the employee
			emp.setEname(nm);
			emp.setSal(sal);
			//session.merge(emp);
			//session.saveOrUpdate(emp);
			session.update(emp);
			tr.commit();
			session.close();
			return true;
		}
		return false;
	}
	@Override
	public Employee findById(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee emp=session.get(Employee.class,id);
		tr.commit();
		session.close();
		return emp;
	}
	@Override
	public List<Employee> sortByName() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Employee e order by e.ename desc");
		List<Employee> elist=query.list();
		tr.commit();
		session.close();
		return elist;
	}

}
