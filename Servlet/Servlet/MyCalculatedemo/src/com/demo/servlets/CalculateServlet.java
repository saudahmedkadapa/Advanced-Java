package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet  extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		//retrieves the data from the form, it uses name property of the form
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		String op=req.getParameter("btn");
		int ans=0;
		if(op.equals("add")) {
			ans=num1+num2;
		}else {
			ans=num1-num2;
		}
		
		out.println("<html><head></head><body>");
		out.println("<h3>Hello From servlet</h3>");
		out.println("Answer : "+ans);
		out.println("</body></html>");
	}

}
