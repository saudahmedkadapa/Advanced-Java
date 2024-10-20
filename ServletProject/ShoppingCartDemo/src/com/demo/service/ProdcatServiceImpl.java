package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.dao.ProdcatDao;
import com.demo.dao.ProdcatDaoImpl;
import com.sun.javadoc.PackageDoc;

public class ProdcatServiceImpl implements ProdcatService{
      private ProdcatDao pdao;

	public ProdcatServiceImpl() {
		pdao=new ProdcatDaoImpl();
	}

	@Override
	public List<Category> getAll() {
		return pdao.findAll();
	}

	@Override
	public List<Product> findAllProduct(int c) {
		return pdao.getAllProduct(c);
	}
      
      
}
