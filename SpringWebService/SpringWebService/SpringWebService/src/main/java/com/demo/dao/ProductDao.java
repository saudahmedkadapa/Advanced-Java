package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProduct();

	int save(Product prod);

	Product findById(int pid);

	int updateProduct(Product p);

	int removeProduct(int pid);

}
