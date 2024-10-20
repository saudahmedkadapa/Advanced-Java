package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String btnString=request.getParameter("btn");
        if(btnString.equals("add")) {
        	// add selected products in the cart
        	HttpSession session=request.getSession();
        	PrintWriter out=response.getWriter();
        	List<Product> cart=(List<Product>) session.getAttribute("cart");
	   		if(cart==null) {
	   			 cart=new ArrayList<>();
	   		}
	   		String[] products=request.getParameterValues("prod");
	   		int[] qty=new int[products.length];
	   		for(int i=0;i<products.length;i++) {
	   			//12:chair:34567
	   			String[] proddetail=products[i].split(":");
	   			qty[i]=Integer.parseInt(request.getParameter(proddetail[1]));
	   			Product product=new Product(Integer.parseInt(proddetail[0]),proddetail[1],qty[i],Double.parseDouble(proddetail[2]));
	   			cart.add(product);		
	   		}
	   		session.setAttribute("cart",cart);
	   		Stream.of(products).forEach(System.out::println);
	   		Stream.of(qty).forEach(System.out::println);
        }
        //and send it back to select the new category
        RequestDispatcher rd=request.getRequestDispatcher("findcategory");
        rd.forward(request, response);
   		
   		
   		
		
	}

}
