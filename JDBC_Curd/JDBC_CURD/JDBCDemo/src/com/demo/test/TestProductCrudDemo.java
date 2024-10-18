package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProductCrudDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService pservice=new ProductServiceImpl();
		int choice=0;
		do {
			System.out.println("1. add new product\n 2. delete by id\n3. display all\n");
			System.out.println("4. display by id\n 5. display by qty\n 6. update product \n");
			System.out.println("7. display in sorted order\n 8. exit \n choice: ");
		
			choice=sc.nextInt();
			
			
			switch (choice) {
			
			case 1:
				pservice.addNewProduct();
				break;
				
			case 2:
				System.out.println("Enter pid to Delete");
				int pid = sc.nextInt();
				boolean status = pservice.deleteById(pid);
				if(status) {
					System.out.println("Deleted Succesfully");
				}else {
					System.out.println("operation failed");
				}
				break;
				
			case 3:
				List<Product>plst =  pservice.displayAll();
				
				plst.forEach(System.out::println);
				break;
				
			case 4:
				System.out.println("Enter pid to Display");
				pid = sc.nextInt();
				Product p = pservice.displayById(pid);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Not Found");
				}
				break;
				
			case 5:
				System.out.println("Enter qty to Display");
				int qty = sc.nextInt();
				plst = pservice.displayByQty(qty);
				
				if(plst!=null) {
					plst.forEach(System.out::println);
				}else {
					System.out.println("Not Found");
				}
				break;
			case 6:
				System.out.println("Enter pid To update");
				pid = sc.nextInt();
				System.out.println("Enter qty To update");
				qty = sc.nextInt();
				System.out.println("Enter price To update");
				float price = sc.nextFloat();
				
				
				status=pservice.modifyById(pid,qty,price);
				if(status) {
					System.out.println("Data updated");
				}else {
					System.out.println("Operation Failed");
				}
				break;
			case 7:
				List<Product> lst = pservice.displaySorted();
				lst.forEach(System.out::println);
				break;
			case 8:
				sc.close();
				pservice.breakConnection();
				System.out.println("Thank you to visit");
				break;
			
			default:
				System.out.println("Invalid choice");
				break;
				
			}

	}while(choice!=8);
	}
	}
