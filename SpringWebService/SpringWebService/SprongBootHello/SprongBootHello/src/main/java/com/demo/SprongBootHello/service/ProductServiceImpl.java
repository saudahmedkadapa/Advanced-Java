package com.demo.SprongBootHello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SprongBootHello.beans.Product;
import com.demo.SprongBootHello.dao.ProductDao;



@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;

	public List<Product> getAllProduct() {
		return pdao.findAll();
	}

	@Override
	public Product getById(int pid) {
		//return pdao.getById(pid);
		return null;
	}
	/*@Override
	public int addproduct(Product prod) {
		return pdao.save(prod);
		
	}

	

	@Override
	public int modifyProduct(Product p) {
		return pdao.updateProduct(p);
	}

	@Override
	public int deleteProduct(int pid) {
		return pdao.removeProduct(pid);
	}*/

}
