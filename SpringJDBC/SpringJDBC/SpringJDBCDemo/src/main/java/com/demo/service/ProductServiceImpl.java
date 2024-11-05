package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;

	public void addnewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enter pname");
		String pname=sc.next();
		System.out.println("enter qty");
		int qty=sc.nextInt();
		System.out.println("enter price");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,qty,price);
		pdao.save(p);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return pdao.findAllProducts();
	}

	@Override
	public Product getById(int pid) {
		return pdao.findById(pid);
	}

	@Override
	public List<Product> getByQty(int qty) {
		return pdao.findByQty(qty);
	}

	@Override
	public List<Product> getSortedByName() {
		return pdao.findSortedDataByName();
		
	}

	@Override
	public boolean modifyProduct(int pid, int qty, double price) {
		return pdao.updateProduct(pid,qty,price);
	}

	@Override
	public boolean deleteProduct(int pid) {
		return pdao.removeById(pid);
	}

}
