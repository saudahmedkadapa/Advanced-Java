package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao pDao;
	
	public ProductServiceImpl() {
		pDao = new ProductDaoImpl();
	}
	
	
	
	@Override
	public void breakConnection() {
		pDao.stopConn();
		
	}



	@Override
	public void addNewProduct() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Pid");
		int pid = sc.nextInt();
		System.out.println("Enter Name");
		String pname = sc.next();
		System.out.println("Enter Qty");
		int qty = sc.nextInt();
		System.out.println("Enter Price");
		float price = sc.nextFloat();
		
		Product p = new Product(pid, pname, qty, price);
		
		pDao.save(p);
		
	}



	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		return pDao.findAll();
	}



	@Override
	public boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		return pDao.removeById(pid);
	}



	@Override
	public Product displayById(int pid) {
		// TODO Auto-generated method stub
		return pDao.findById(pid);
	}



	@Override
	public List<Product> displayByQty(int qty) {
		// TODO Auto-generated method stub
		return pDao.findByQty(qty);
	}



	@Override
	public boolean modifyById(int pid, int qty, float price) {
		// TODO Auto-generated method stub
		return pDao.updateById(pid,qty,price);
	}



	@Override
	public List<Product> displaySorted() {
		// TODO Auto-generated method stub
		return pDao.sortByPrice();
	}

	
	
	
	
	
}
