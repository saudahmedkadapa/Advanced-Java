package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
        MyClass ob=(MyClass) ctx.getBean("myClass");
		ob.mymethod1(12);
		ob.mymethod2();
		ob.game1();
		ob.game2();
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
