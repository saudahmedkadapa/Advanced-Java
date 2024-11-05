package com.demo.dao;

import java.sql.ResultSet;
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

	public void save(Product p) {
		int n=jdbcTemplate.update("insert into product values(?,?,?,?)",
				new Object[] {p.getPid(),p.getPname(),p.getPrice(),p.getQty()});
		
	}

	@Override
	public List<Product> findAllProducts() {
		//mapRow(ResultSet rs,int num) of RowMapper interface
		RowMapper rm=(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			return p;
			
		};
		List<Product> plist=jdbcTemplate.query("select * from product",rm);
		return plist;
	}

	@Override
	public Product findById(int pid) {
		Product p=jdbcTemplate.queryForObject("select * from product where pid=?",
				new Object[] {pid},
				BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	@Override
	public List<Product> findByQty(int qty) {
		//mapRow(ResultSet rs,int num) of RowMapper interface
				RowMapper rm=(rs,num)->{
					Product p=new Product();
					p.setPid(rs.getInt(1));
					p.setPname(rs.getString(2));
					p.setQty(rs.getInt(4));
					p.setPrice(rs.getDouble(3));
					return p;
					
				};
				List<Product> plist=jdbcTemplate.query("select * from product where qty>?",new Object[] {qty},rm);
				return plist;
	}

	@Override
	public List<Product> findSortedDataByName() {
		RowMapper rm=(rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(4));
			p.setPrice(rs.getDouble(3));
			return p;
			
		};
		List<Product> plist=jdbcTemplate.query("select * from product order by pname",rm);
		return plist;
	}

	@Override
	public boolean updateProduct(int pid, int qty, double price) {
		int n=jdbcTemplate.update("update product set qty=?,price=? where pid=?",
				new Object[] {qty,price,pid});
		return  n>0;
	}

	@Override
	public boolean removeById(int pid) {
		int n=jdbcTemplate.update("delete from product where pid=?",
				new Object[] {pid});
		return  n>0;
	}

}
