package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestJDBC {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService pservice=(ProductService) ctx.getBean("productServiceImpl");
		int choice=0;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("1. add new product\n 2. delete product \n 3. modify product");
		System.out.println("4. display all\n 5. display by id\n6. display by qty");
		System.out.println("7. display in sorted order\n 8. exit\n choice: ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			pservice.addnewProduct();
			break;
		case 2:
			System.out.println("enter the pid");
			int pid=sc.nextInt();
			boolean status=pservice.deleteProduct(pid);
			if(status) {
				System.out.println("Deleted successfully");
			}else {
				System.out.println("Not Found");
			}
			break;
		case 3:
			System.out.println("enter the pid");
			pid=sc.nextInt();
			System.out.println("enter the qty");
			int qty=sc.nextInt();
			System.out.println("enter the price");
			double price=sc.nextDouble();
			 status=pservice.modifyProduct(pid,qty,price);
			if(status) {
				System.out.println("updated successfully");
			}else {
				System.out.println("Not Found");
			}
			break;
		case 4:
			List<Product> plist=pservice.getAllProducts();
			plist.forEach(System.out::println);
			break;
		case 5:
			System.out.println("enter the pid");
			 pid=sc.nextInt();
			Product p=pservice.getById(pid);
			if(p!=null) {
				System.out.println(p);
			}else {
				System.out.println("not found"+pid);
			}
			break;
		case 6:
			System.out.println("enter the quantity");
			qty=sc.nextInt();
			plist=pservice.getByQty(qty);
			plist.forEach(System.out::println);
			
			break;
		case 7:
			plist=pservice.getSortedByName();
			plist.forEach(System.out::println);
			break;
		case 8:
			((ClassPathXmlApplicationContext)ctx).close();
			sc.close();
			System.out.println("Thanl you for visiting...");
			break;
		}
		}while(choice!=8);
	}
}




