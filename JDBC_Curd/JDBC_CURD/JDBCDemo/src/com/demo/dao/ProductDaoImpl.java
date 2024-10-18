package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
     static Connection conn;
     static PreparedStatement pinsert,pSelect,pDelete,pSelectById,pSelectByQty,pUpdateById,pSorted;
     
     static {
    	 conn = DBUtil.getMyConnection();
    	 try {
			pinsert = conn.prepareStatement("insert into product values (?,?,?,?)");
			pSelect = conn.prepareStatement("select * from product");
            pDelete = conn.prepareStatement("delete from product where pid = ?");
            pSelectById = conn.prepareStatement("select * from product where pid = ?");
            pSelectByQty = conn.prepareStatement("select * from product where qty<= ?");
            pUpdateById = conn.prepareStatement("update product set qty=?,price=? where pid=?");
            pSorted = conn.prepareStatement("select * from product order by price");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	@Override
	public void stopConn() {
		DBUtil.closeMyConnection();
		
	}

	@Override
	public void save(Product p) {
		try {
			pinsert.setInt   (1, p.getPid());
			pinsert.setString(2, p.getPname());
			pinsert.setInt   (3, p.getQty());
			pinsert.setFloat (4, p.getPrice());
			
			int n = pinsert.executeUpdate();
			if(n>0) {
				System.out.println("Insertion Done");
			}else {
				System.out.println("operation failed");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> findAll() {
		
		try {
			ResultSet rs = pSelect.executeQuery();
			List<Product> plst = new ArrayList<>();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				plst.add(p);
			}
			return plst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public boolean removeById(int pid) {
		try {
			pDelete.setInt(1, pid);
			int n = pDelete.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product findById(int pid) {
		try {
			pSelectById.setInt(1, pid);
			ResultSet rs = pSelectById.executeQuery();
			if(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				return p;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Product> findByQty(int qty) {
		try {
			pSelectByQty.setInt(1, qty);
			ResultSet rs = pSelectByQty.executeQuery();
			
			List<Product> plst = new ArrayList<>();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				plst.add(p);
			}
			if(plst.size()>0) {
			   return plst;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateById(int pid, int qty, float price) {
		try {
			pUpdateById.setInt  (1, qty);
			pUpdateById.setFloat(2, price);
			pUpdateById.setInt  (3, pid);
			
			int n = pUpdateById.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> sortByPrice() {
		
		try {
			ResultSet rs = pSorted.executeQuery();
			
			List<Product> plst = new ArrayList<>();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
				plst.add(p);
			}
			return plst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
