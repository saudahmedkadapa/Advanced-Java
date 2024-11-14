package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.User;
import com.demo.dao.UserRepository;

@Service
public class MyAuthenticateServiceImpl implements MyAutheticateService {
    @Autowired
	private UserRepository userRepository;
    
	@Override
	public void adduser(User user) {
		System.out.println(user);
		userRepository.save(user);
		
	}

}
