package com.demo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Category;
import com.demo.service.ProdcatService;
import com.demo.service.ProdcatServiceImpl;


@WebServlet("/findcategory")
public class FindCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//find the category list from the databse and send it to jsp page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdcatService pservice=new ProdcatServiceImpl();
		List<Category> cList=pservice.getAll();
		request.setAttribute("clist", cList);
		RequestDispatcher rd=request.getRequestDispatcher("displaycategory.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}
	

}
