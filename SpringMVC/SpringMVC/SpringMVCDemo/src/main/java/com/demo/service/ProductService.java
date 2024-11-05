package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	int addproduct(Product prod);

	Product getById(int pid);

	int modifyProduct(Product p);

	int deleteProduct(int pid);

}
