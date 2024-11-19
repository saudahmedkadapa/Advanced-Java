package com.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.service.UserService;

@Controller
public class MyUserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String displayform(Model m) {
		MyUser myUser=new MyUser();
		List<String> professionList=Arrays.asList("Developer","Designer","tester");
		m.addAttribute("professionList", professionList);
		m.addAttribute("myUser", myUser);
		return "registrationform";
	}
	
	@GetMapping("/edituser/{name}")
	public ModelAndView editUSer(@PathVariable String name) {
		MyUser user=userService.getById(name);
		return new ModelAndView("edituser","myUser",user);
	}
	
	@GetMapping("/allusers")
	public ModelAndView getAllUSers() {
		List<MyUser> ulist=userService.getAllUSers();
		return new ModelAndView("displayuser","ulist",ulist);
	}
	@PostMapping("/register")
	public ModelAndView submitform(@Valid @ModelAttribute("myUser") MyUser myUser,BindingResult bindingResult,Model m) {
		System.out.println("in submit form");
		System.out.println(myUser);
		if(bindingResult.hasErrors()) {
			List<String> professionList=Arrays.asList("Developer","Designer","tester");
			m.addAttribute("professionList", professionList);
			return new ModelAndView("registrationform");
		}
		userService.addnewUSer(myUser);
		return new ModelAndView("redirect:/allusers");
	}
	
	@PostMapping("/updatedata")
	public ModelAndView updateUSer(@Valid @ModelAttribute("myUser") MyUser myUser,BindingResult bindingResult,Model m) {
		System.out.println("in submit form");
		System.out.println(myUser);
		if(bindingResult.hasErrors()) {
			List<String> professionList=Arrays.asList("Developer","Designer","tester");
			m.addAttribute("professionList", professionList);
			return new ModelAndView("edituser");
		}
		userService.updateUSer(myUser);
		return new ModelAndView("redirect:/allusers");
	}
	
	@GetMapping("/deleteuser/{name}")
	public ModelAndView deleteUser(@PathVariable String name)
	{
		userService.deleteUser(name);
		return new ModelAndView("redirect:/allusers");
	}

}
