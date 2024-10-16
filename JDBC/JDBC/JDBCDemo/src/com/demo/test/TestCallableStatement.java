package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;

public class TestCallableStatement {
	public static void main(String[] args) {
		
	
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test";
			Connection conn=DriverManager.getConnection(url,"root","root123");
			if(conn!=null) {
				System.out.println("Connection done!!");
			}
			CallableStatement cs=conn.prepareCall("{call getcnt11(?,?)}");
			cs.setInt(1, 10);
			cs.registerOutParameter(2,Types.INTEGER);
			cs.execute();
			int num=cs.getInt(2);
			System.out.println("count of dept 10 : "+num);
		    conn.close(); //better to put in finally block
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
