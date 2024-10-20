package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProdcatService{

	List<Category> getAll();

	List<Product> findAllProduct(int c);

}
