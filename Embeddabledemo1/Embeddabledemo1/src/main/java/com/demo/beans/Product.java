package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product12")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	@Column(nullable = false )
	private String pname;
	private int qty;
	private double price;
	public Product() {
		super();
	}
	public Product( String pname, int qty, double price) {
		super();
		
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	public Product(int qty, double price) {
		super();
		
		//this.pname = pname;
		this.qty = qty;
		this.price = price;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}
	

}
