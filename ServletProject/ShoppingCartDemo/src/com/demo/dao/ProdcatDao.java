package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProdcatDao {

	List<Category> findAll();

	List<Product> getAllProduct(int c);

}
