package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPrepareStatement {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test";
			conn=DriverManager.getConnection(url,"root","root123");
			//set autocommit off
			conn.setAutoCommit(false);
			if(conn!=null) {
				System.out.println("Connection done!!");
			}
			PreparedStatement ps=conn.prepareStatement("select * from product where price<=?");
			double price=100;
			ps.setDouble(1,price);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("pid : "+rs.getInt("pid"));
				System.out.println("pname: "+rs.getString("pname"));
				System.out.println("Qty : "+rs.getInt("qty"));
				System.out.println("price : "+rs.getDouble("price"));
				System.out.println("------------------------");
			}
			PreparedStatement ps1=conn.prepareStatement("insert into product values(?,?,?,?)");
			ps1.setInt(1, 10);
			ps1.setString(2, "xxxx");
			ps1.setInt(3, 34);
			ps1.setDouble(4, 345);
			int n=ps1.executeUpdate();
			if(n>0) {
				System.out.println("inserted");
				//commit the changes
				conn.commit();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//rollback the transaction
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
