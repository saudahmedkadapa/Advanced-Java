package com.demo.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="myemp11")
public class Employee {
	@Id
	private int empid;
	private String ename;
	private double sal;
	@ManyToMany
	@JoinTable(name="emp_proj",joinColumns= {@JoinColumn(name="empno")},
	inverseJoinColumns= {@JoinColumn(name="projno")})
	private Set<Project> pset=new HashSet<>();
	public Employee() {
		super();
	}
	
	public Employee(int empid, String ename, double sal, Set<Project> pset) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
		this.pset = pset;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Set<Project> getPset() {
		return pset;
	}
	public void setPset(Set<Project> pset) {
		this.pset = pset;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", sal=" + sal + ", pset=" + pset + "]";
	}
	

}
