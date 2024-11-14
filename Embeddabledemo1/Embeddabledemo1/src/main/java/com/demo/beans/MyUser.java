package com.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myuser12")
public class MyUser {
	@Id
	private int uid;
	@Column(name="uname")
	private String name;
	private String email;
	private String mob;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String name, String email, String mob) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.mob = mob;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", name=" + name + ", email=" + email + ", mob=" + mob + "]";
	}
}