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

import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@RestController
public class ProductController {

   @Autowired	
   ProductService pservice;
   
   @GetMapping("/products")
   public ResponseEntity<List<Product>> getAllProducts(){
	   List<Product> plist=pservice.getAllProducts();
	   return ResponseEntity.ok(plist);
	   
   }
   
   @GetMapping("/products/{id}")
   public ResponseEntity<Product> getById(@PathVariable int id){
	   Product p=pservice.getById(id);
	   if(p!=null) {
		   return ResponseEntity.ok(p);
	   }else {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
   }
   
   @PostMapping("/products/{id}")
   public ResponseEntity<String> insertProduct(@RequestBody Product p){
	   int n=pservice.addProduct(p);
	   if(n>0) {
		   return ResponseEntity.ok("data added successfully");
	   }else {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
   }
   
   @PutMapping("/products/{id}")
   public ResponseEntity<String> updateProduct(@RequestBody Product p){
	   int n=pservice.modifyProduct(p);
	   if(n>0) {
		   return ResponseEntity.ok("data updated successfully");
	   }else {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
   }
   
   @DeleteMapping("/products/{id}")
   public ResponseEntity<String> deleteById(@PathVariable int id){
	   pservice.deleteById(id);
	   return ResponseEntity.ok("Data deleted successfully");
	   //		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   
   }
   
   @GetMapping("/products/price/{lowprice}/{highprice}")
   public ResponseEntity<List<Product>> getByPrice(@PathVariable double lowprice, @PathVariable double highprice){
	   List<Product> plist=pservice.getByPrice(lowprice,highprice);
	   if(plist.size()>0)
	         return ResponseEntity.ok(plist);
	   else
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   
   }
   
}
