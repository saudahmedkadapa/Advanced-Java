package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void breakConnection();

	void addNewProduct();

	List<Product> displayAll();

	boolean deleteById(int pid);

	Product displayById(int pid);

	List<Product> displayByQty(int qty);

	boolean modifyById(int pid, int qty, float price);

	List<Product> displaySorted();

}
