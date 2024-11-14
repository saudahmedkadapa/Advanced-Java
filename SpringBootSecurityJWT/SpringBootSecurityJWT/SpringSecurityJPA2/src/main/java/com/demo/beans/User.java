package com.demo.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="myuser23")
public class User {
	@Id
	private int user_id;
	private String username;
	private String password;
	private String email;
	//private String role;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_role23",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	public User() {
		super();
	}
	public User(int user_id, String username, String password, String email, Set<Role> roles) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", roles=" + roles + "]";
	}

}
