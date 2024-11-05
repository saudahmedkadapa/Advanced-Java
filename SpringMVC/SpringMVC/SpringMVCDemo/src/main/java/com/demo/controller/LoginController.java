package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService lservice;
	
	@GetMapping("/mylogin")
	public String showloginform() {
		return "loginpage";
	}
	
	@PostMapping("/validateuser")
	public ModelAndView validateuser(HttpSession session,@RequestParam String uname,@RequestParam("pass") String p1){
		MyUser u=lservice.authenticateUser(uname,p1);
		if(u!=null) {
			session.setAttribute("user", u);
		    if(u.getRole().equals("admin")){
			    return new ModelAndView("redirect:/product/viewproducts");
		   }
		}else {
			return new ModelAndView("loginpage","msg","Pls reneter credentials");
		}
		//return new ModelAndView("loginpage","msg","Pls reneter credentials");;
		return null;
	} 
}
