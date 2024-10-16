package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		try {
			//step 1: register driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test";;
			//step 2: get connection
			Connection conn=DriverManager.getConnection(url,"root","root123");
			if(conn!=null) {
				System.out.println("connection done!!");
			}
			//step 3-- create a statement
			Statement st=conn.createStatement();
			displaydata(st);
			int pid=121;
			String pname="table";
			int qty=34;
			double price=456;
			String s="insert into product values("+pid+",'"+pname+"',"+qty+","+price+")";
			System.out.println("Query : "+s);	
			int n=st.executeUpdate(s);
			if(n>0) {
				System.out.println("inserted");
			}
			displaydata(st);
			String s1="xxx' or '1' = '1";
			String query="select * from product where pname='"+s1+"'";
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Pid : "+rs.getInt(1));
				System.out.println("pname : "+rs.getString(2));
				System.out.println("Quantity : "+rs.getInt(3));
				System.out.println("Price : "+rs.getDouble(4));
				System.out.println("*********************************");
			}
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void displaydata(Statement st) {
		ResultSet rs;
		try {
			rs = st.executeQuery("Select * from product");
			while(rs.next()) {
				System.out.println("Pid : "+rs.getInt(1));
				System.out.println("pname : "+rs.getString(2));
				System.out.println("Quantity : "+rs.getInt(3));
				System.out.println("Price : "+rs.getDouble(4));
				System.out.println("-----------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
