package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.User;
import com.demo.service.MyAutheticateService;

@RestController
public class Admincontroller {
	
	@Autowired
	MyAutheticateService aservice;
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("admin/add")
	public ResponseEntity<String> adduser(@RequestBody User user) {
		String pass=user.getPassword();
		String encryptPassword=passwordEncoder.encode(pass);
		user.setPassword(encryptPassword);
		aservice.adduser(user);
		return ResponseEntity.ok("user added successfully");
		
	}
	@GetMapping("/performlogout")
	public String logoutdone() {
		return "Thank you for visiting......";
	}

}
