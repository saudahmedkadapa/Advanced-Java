package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	List<Product> findAllProducts();

	Product findById(int pid);

	List<Product> findByQty(int qty);

	List<Product> findSortedDataByName();

	boolean updateProduct(int pid, int qty, double price);

	boolean removeById(int pid);

}
