package com.demo.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.beans.User;

public class CustomUserDetails implements UserDetails{
     private User user;
     
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("in getAuthorities method of CustomUserDetails");
		Collection<? extends GrantedAuthority> lst= user.getRoles().stream().map(roledata->new SimpleGrantedAuthority(roledata.getRole()))
				.collect(Collectors.toList());
		lst.forEach(data->{System.out.println(data.getAuthority());});
		return lst;
	}

	public String getPassword() {
		System.out.println("in getPassword CustomUserDetails");
		return user.getPassword();
	}

	public String getUsername() {
		System.out.println("in getusername CustomUserDetails");
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
