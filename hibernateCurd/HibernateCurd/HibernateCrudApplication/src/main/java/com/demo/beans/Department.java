package com.demo.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mydept")
public class Department {
	@Id
   private int deptno;
   private String dname;
   private String dloc;
   @OneToMany(mappedBy="dept",orphanRemoval=true,cascade=CascadeType.REFRESH)
   private Set<Employee> eset=new HashSet<>();
	public Department() {
		super();
		
	}
	
	public Department(int deptno) {
		super();
		this.deptno = deptno;
	}

	public Department(int deptno, String dname, String dloc, Set<Employee> eset) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.dloc = dloc;
		this.eset = eset;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public Set<Employee> getEset() {
		return eset;
	}
	public void setEset(Set<Employee> eset) {
		this.eset = eset;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname +  "]";
	}
	
   
}
