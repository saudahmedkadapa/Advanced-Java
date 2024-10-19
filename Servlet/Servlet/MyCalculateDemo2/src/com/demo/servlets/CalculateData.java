package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateData extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("in init method");
	}
	public int factorial(int n) {
		int f=1;
		for(int i=1;i<=n;i++) {
			f=f*i;
		}
		return f;
	}
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	   response.setContentType("text/html");
	   PrintWriter out=response.getWriter();
	   int n1=Integer.parseInt(request.getParameter("num1"));
	   String op=request.getParameter("btn");
	   if(op.equals("factorial")) {
		   int ans=factorial(n1);
		   out.println("Factorial : "+ans);
	   }else {
		   for(int i=1;i<=10;i++) {
			   out.println(n1 + " * "+i+" = "+(n1*i)+"<br>");
		   }
	   }
	   
   }
   
   public void destroy() {
	   System.out.println("in destroy method");
   }
}
