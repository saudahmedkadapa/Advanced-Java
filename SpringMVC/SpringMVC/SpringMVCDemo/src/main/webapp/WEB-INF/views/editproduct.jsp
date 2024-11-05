<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/SpringMVCDemo/product/updateproduct" method="post">
     Product Id : <input type="text" name="pid" id="pid" value="${prod.pid}" readonly><br>
     Product name : <input type="text" name="pname" id="pnm" value="${prod.pname}"><br>
     Product qty : <input type="text" name="qty" id="qty" value="${prod.qty}"><br>
     Product price : <input type="text" name="price" id="price" value="${prod.price}"><br>
     <button type="submit" name="btn" id="btn" value="add">Update  product</button>
  </form>
</body>
</html>