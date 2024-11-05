package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addnewProduct();

	List<Product> getAllProducts();

	Product getById(int pid);

	List<Product> getByQty(int qty);

	List<Product> getSortedByName();

	boolean modifyProduct(int pid, int qty, double price);

	boolean deleteProduct(int pid);

}
