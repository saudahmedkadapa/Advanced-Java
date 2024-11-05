package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller

@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/viewproducts")
	public ModelAndView displayProduct() {
		List<Product> plist=pservice.getAllProduct();
		return new ModelAndView("displayproduct","plist",plist);
	}
	
	
	@GetMapping("/addnewproduct")
	public ModelAndView displayaddform() {
		Product p=new Product();
		return new ModelAndView("addproduct","p",p);
	}
	
	@PostMapping("/insertproduct")
	public ModelAndView insertProduct(@ModelAttribute("p") Product prod) {
		System.out.println(prod);
		pservice.addproduct(prod);
		return  new ModelAndView("redirect:/product/viewproducts");
		
	}
	
	@GetMapping("/editproduct/{id}")
	public ModelAndView editById(@PathVariable("id") int pid) {
		Product p=pservice.getById(pid);
		return new ModelAndView("editproduct","prod",p);
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateProduct(@ModelAttribute("prod") Product p ) {
		System.out.println(p);
		int n=pservice.modifyProduct(p);
		return  new ModelAndView("redirect:/product/viewproducts");
	}
	
	@GetMapping("/deleteproduct/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int pid) {
		int n=pservice.deleteProduct(pid);
		return  new ModelAndView("redirect:/product/viewproducts");
	}
	
	

}
