package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
   @Autowired	
   private JdbcTemplate jdbcTemplate;

public List<Product> findAllProduct() {
	
	List<Product> plist=jdbcTemplate.query("select * from product", (rs,num)->{
		Product p=new Product();
		p.setPid(rs.getInt(1));
		p.setPname(rs.getString(2));
		p.setQty(rs.getInt(3));
		p.setPrice(rs.getDouble(4));
		return p;
	});
	return plist;
}

@Override
public int save(Product prod) {
	return jdbcTemplate.update("insert into product values(?,?,?,?)",
			new Object[] {prod.getPid(),prod.getPname(),prod.getQty(),prod.getPrice()});
	
}

@Override
public Product findById(int pid) {
	return jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid},
			BeanPropertyRowMapper.newInstance(Product.class));
}

@Override
public int updateProduct(Product prod) {
	return jdbcTemplate.update("update product set pname=?,qty=?,price=? where pid=?",
			new Object[] {prod.getPname(),prod.getQty(),prod.getPrice(),prod.getPid()});
}

@Override
public int removeProduct(int pid) {
	return jdbcTemplate.update("delete from  product where pid=?",
			new Object[] {pid});
}
   
   
	
}
