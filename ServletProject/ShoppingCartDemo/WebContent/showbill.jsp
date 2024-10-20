<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.demo.beans.Product,java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--display the bill by retrieving data from the cart --%>
   <table border='2'>
   <tr>
     <th>Product Id</th>
     <th>Name</th>
     <th>order qty</th>
     <th>price</th>
     <th>Amount</th>
   </tr>
   <%
     double total=0; 
     List<Product> plist=(List<Product>)session.getAttribute("cart");
   for(Product prod:plist){
   %>
   
      <tr>
         <td><%=prod.getPid() %></td>
         <td><%=prod.getPname() %></td>
         <td><%=prod.getQty() %></td>
         <td><%=prod.getPrice() %></td>
         <td><%=prod.getPrice() * prod.getQty() %></td>
      </tr>
      <% total=total+(prod.getQty()*prod.getPrice()); %> 
    <%} %>
   <tr>
      <td colspan='4'>Total bill amount</td>
      <td><%=total %></td>
   </tr>
   </table>
   <form action="dopayment.jsp">
   <input type="hidden" name="amt" id="amt" value="<%=total %>"></input>
   <button type="submit" name="btn" id="btn" value="pay">Pay the bill</button>
   <button type="submit" name="btn" id="btn" value="add">Add more Products</button>
   </form>
</body>
</html>