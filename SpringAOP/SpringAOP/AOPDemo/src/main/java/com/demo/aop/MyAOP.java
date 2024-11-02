package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOP {
	
	@Before("execution (* com.demo.beans.*.my*(..))")
	public void beformethod() {
		System.out.println("in before advice");
	}
	
	@After("execution (* com.demo.beans.*.my*(..))")
	public void aftermethod() {
		System.out.println("in after advice");
	}
	
	@Around("execution (* com.demo.beans.*.my*(..))")
	public Object aroundadvice(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("in around advice beforecall");
		System.out.println("in around advice beforecall");
		//actual method will get called
		Object ob=joinpoint.proceed();
		System.out.println("in around advice aftercall");
		return ob;
	}

}
