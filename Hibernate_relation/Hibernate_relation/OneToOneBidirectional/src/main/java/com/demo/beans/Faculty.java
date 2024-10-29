package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="myfaculty")
public class Faculty {
	@Id
   private int facid;
   private String fname;
   private int years;
   @OneToOne(mappedBy="fac",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private Course c;
	public Faculty() {
		super();
	}
	
	
	public Faculty(int facid, String fname, int years, Course c) {
		super();
		this.facid = facid;
		this.fname = fname;
		this.years = years;
		this.c = c;
	}


	public Course getC() {
		return c;
	}
	public void setC(Course c) {
		this.c = c;
	}
	public int getFacid() {
		return facid;
	}
	public void setFacid(int facid) {
		this.facid = facid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	@Override
	public String toString() {
		return "Faculty [facid=" + facid + ", fname=" + fname + ", years=" + years + "]";
	}
   
}
