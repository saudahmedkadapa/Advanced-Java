package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Product {
   @Value("10")
   private int pid;
   @Value("chair")
   private String pname;
   @Value("15")
   private int qty;
   @Autowired
   private Category c;
public Product() {
	super();
}

public Category getC() {
	return c;
}

public void setC(Category c) {
	this.c = c;
}

public Product(int pid, String pname, int qty, Category c) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.qty = qty;
	this.c = c;
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

@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", c=" + c + "]";
}
 
}
