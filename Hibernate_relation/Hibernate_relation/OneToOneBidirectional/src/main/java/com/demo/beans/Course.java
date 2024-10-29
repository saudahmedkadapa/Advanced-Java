package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mycourse")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseid;
	private String cname;
	private int duration;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="facid")
	private Faculty fac;
	public Course() {
		super();
	}
	public Course(int courseid, String cname, int duration, Faculty fac) {
		super();
		this.courseid = courseid;
		this.cname = cname;
		this.duration = duration;
		this.fac = fac;
	}
	
	public Course(String cname, int duration, Faculty fac) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.fac = fac;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Faculty getFac() {
		return fac;
	}
	public void setFac(Faculty fac) {
		this.fac = fac;
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", cname=" + cname + ", duration=" + duration + ", fac=" + fac + "]";
	}
	

}
