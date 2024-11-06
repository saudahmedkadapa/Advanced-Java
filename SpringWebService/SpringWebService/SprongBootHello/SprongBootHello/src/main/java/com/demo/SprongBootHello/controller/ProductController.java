package com.demo.SprongBootHello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SprongBootHello.beans.Product;
import com.demo.SprongBootHello.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> plist=pservice.getAllProduct();
		return ResponseEntity.ok(plist);
		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Product p=pservice.getById(id);
		if(p!=null)
		   return ResponseEntity.ok(p);
		else
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		
	}

}
