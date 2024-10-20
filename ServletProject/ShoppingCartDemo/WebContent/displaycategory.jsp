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
<h1>Select category</h1>
<%--to display all category in the drop down list
and will take us to findProduct servlet to find list of products --%>
<form action="findproduct">
<select name="c" id="c">
   <c:forEach var="c" items="${clist}">
      <option value="${c.cid}">${c.cname}</option>
   </c:forEach>
</select>
<button type="submit" name="btn" id="btn" value="find">Find Product</button>
<button type="submit" name="btn" id="btn" value="order">Place Order</button>
</form>

</body> 
</html>