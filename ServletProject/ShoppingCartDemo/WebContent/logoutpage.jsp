<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session.invalidate(); %>
  <h3>Your order is placed successfully...</h3>
  <h3>Do visit again.....</h3>
  <a href="findcategory">place new order</a>
</body>
</html>