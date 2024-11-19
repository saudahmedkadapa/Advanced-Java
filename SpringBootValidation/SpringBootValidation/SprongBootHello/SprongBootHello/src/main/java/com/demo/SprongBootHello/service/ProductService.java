package com.demo.SprongBootHello.service;

import java.util.List;

import com.demo.SprongBootHello.beans.Product;



public interface ProductService {

	List<Product> getAllProduct();
	Product getById(int pid);

	/*int addproduct(Product prod);

	int modifyProduct(Product p);

	int deleteProduct(int pid);*/

}
