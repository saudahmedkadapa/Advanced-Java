package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myuser12")
public class MyUser {
	//to use it as a primary key
	@Id
	private int uid;
	//to change the column name
	@Column(name="uname")
	private String name;
	private String email;
	private String mob;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String name, String email,String mob) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.mob=mob;
	}
	public String getMob() {
		System.out.println("in getmobile");
		return mob;
	}
	public void setMob(String mob) {
		System.out.println("in setmobile");
		this.mob = mob;
	}
	public int getUid() {
		System.out.println("in getuid");
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in setuid");
		this.uid = uid;
	}
	public String getName() {
		System.out.println("in getname");
		return name;
	}
	public void setName(String name) {
		System.out.println("in setuname");
		this.name = name;
	}
	public String getEmail() {
		System.out.println("in getemail");
		return email;
	}
	public void setEmail(String email) {
		System.out.println("in setemail");
		this.email = email;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", name=" + name + ", email=" + email + ", mob=" + mob + "]";
	}
	

}
