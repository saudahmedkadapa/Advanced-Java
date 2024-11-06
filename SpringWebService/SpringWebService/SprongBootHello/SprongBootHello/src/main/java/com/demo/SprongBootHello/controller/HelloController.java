package com.demo.SprongBootHello.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	 @GetMapping("/hello")
     public String sayhello() {
    	 return "<h1>Hello World!!<h1>";
     }
}
