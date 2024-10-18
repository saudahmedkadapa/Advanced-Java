package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void stopConn();

	void save(Product p);

	List<Product> findAll();

	boolean removeById(int pid);

	Product findById(int pid);

	List<Product> findByQty(int qty);

	boolean updateById(int pid, int qty, float price);

	List<Product> sortByPrice();

}
