package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.beans.User;
import com.demo.dao.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
    @Autowired
	private UserRepository useRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in loadbyusername "+username);
		CustomUserDetails customerDetails=null;
		User user=useRepository.findByUserName(username);
		System.out.println(user);
		if(user!=null) {
			customerDetails=new CustomUserDetails();
			customerDetails.setUser(user);
			
		}else {
			throw new UsernameNotFoundException("User not exists");
		}
		return customerDetails;
	}

}
