package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//@RequestMapping(value="/hello",method=RequestMethod.GET)
	@GetMapping("/hello")
	public ModelAndView sayhello() {
		String message="Welcome to spring MVC application";
		return new ModelAndView("myhello","msg",message);
	}
	
	@GetMapping("/welcome")
	public String saywelcome(Model ob) {
		ob.addAttribute("message", "welcome to springMVC");
		ob.addAttribute("name", "IET students");
		return "welcome";
	}
	
	@GetMapping("/")
	public String displayhomepage() {
		
		return "index";
	}

}
