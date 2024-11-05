<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
   <th>Product Id</th>
   <th>Product Name</th>
   <th>Product qty</th>
   <th>Product price</th>
   <th>actions</th>
</tr>
<c:forEach var="prod" items="${plist}">
   <tr>
      <td>${prod.pid}</td>
      <td>${prod.pname}</td>
      <td>${prod.qty}</td>
      <td>${prod.price}</td>
      <td>
         <a href="#">delete</a>/
         <a href="#">edit</a>/
         <a href="#">view</a>
      </td>
   </tr>
</c:forEach>
</table>
<a href="#">add new product</a>
</body>
</html>