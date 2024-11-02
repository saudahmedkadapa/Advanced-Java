package com.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
	
	public int mymethod1(int x) {
		System.out.println("in mymethod "+x);
		return x+10;
	}
	public void mymethod2() {
		System.out.println("in mymethod2 ");
	
	}
	public void  game1(){
		System.out.println("in game1");
	}
	public int  game2(){
		System.out.println("in game2");
		return 10;
	}
	

}
