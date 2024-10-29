package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myfaculty")
public class Faculty {
	@Id
   private int facid;
   private String fname;
   private int years;
	public Faculty() {
		super();
	}
	public Faculty(int facid, String fname, int years) {
		super();
		this.facid = facid;
		this.fname = fname;
		this.years = years;
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
