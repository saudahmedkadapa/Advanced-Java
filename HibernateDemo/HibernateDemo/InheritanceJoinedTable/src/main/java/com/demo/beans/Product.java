package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name="Myproductjoined")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
	@Id
	private int pid;
	private String pname;
	private LocalDate mfgdate;
	public Product() {
		super();
	}
	public Product(int pid, String pname, LocalDate mfgdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.mfgdate = mfgdate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public LocalDate getMfgdate() {
		return mfgdate;
	}
	public void setMfgdate(LocalDate mfgdate) {
		this.mfgdate = mfgdate;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", mfgdate=" + mfgdate + "]";
	}
	

}
