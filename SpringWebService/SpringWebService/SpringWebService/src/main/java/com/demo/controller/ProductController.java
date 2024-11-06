package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getallproducts(){
		List<Product> plist= pservice.getAllProduct();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getproductById(@PathVariable("id") int pid){
		Product p=pservice.getById(pid);
		if(p!=null) {
			//returns a object that it found
			return ResponseEntity.ok(p);
		}else {
			//return failure, data not found
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/products/{id}")
	public ResponseEntity<String> insertProduct(@RequestBody Product p){
		int n=pservice.addproduct(p);
		if(n>0)
			return ResponseEntity.ok("Data added successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p){
		int n=pservice.modifyProduct(p);
		if(n>0)
			return ResponseEntity.ok("Data updated successfully");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		int n=pservice.deleteProduct(id);
		if(n>0)
			return new ResponseEntity("Data deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity("data not found"+id,HttpStatus.NOT_FOUND);
	}
	
	

}
