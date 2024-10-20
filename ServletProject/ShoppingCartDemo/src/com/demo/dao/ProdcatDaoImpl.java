package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.demo.beans.Category;
import com.demo.beans.Product;




public class ProdcatDaoImpl implements ProdcatDao{
	static Connection conn;
	static PreparedStatement pcatsel,prodselect;
	static {
		conn=DBUtil.getMyConnection();
		try {
			pcatsel=conn.prepareStatement("select * from category");
			prodselect=conn.prepareStatement("select * from prodcat where catid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Category> findAll() {
		ResultSet rs;
		try {
			rs = pcatsel.executeQuery();
			List<Category> cList=new ArrayList<>();
			while(rs.next()) {
				Category c=new Category(rs.getInt(1),rs.getString(2),rs.getString(3));
				cList.add(c);
			}
			return cList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
			
	}
	@Override
	public List<Product> getAllProduct(int c) {
		try {
			prodselect.setInt(1, c);
			ResultSet rs=prodselect.executeQuery();
			List<Product> pList=new ArrayList<>();
			while(rs.next()) {
				Product product=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
				pList.add(product);
			}
			return pList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
