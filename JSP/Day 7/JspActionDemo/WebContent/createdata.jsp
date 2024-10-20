<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
pid : <%=request.getParameter("pid") %> ------ ${param.pid}
<!-- html comment -->
    <%--JSP comment-----it will call default constructor --%>
   <jsp:useBean id="p" class="com.demo.beans.Product"></jsp:useBean>
  <%--  <jsp:setProperty property="pid" name="p" value='<%=request.getParameter("pid") %>'/>
  --%>
  <jsp:setProperty property="*" name="p"/>
  <h2>Display product data</h2>
  Pid : <jsp:getProperty property="pid" name="p"/> ----${p.pid}
   Pname : <jsp:getProperty property="pname" name="p"/>----${p.pname}
   Quantity :<jsp:getProperty property="qty" name="p"/>---${p.qty}
   Price :  <jsp:getProperty property="price" name="p"/>---${p.qty}
  
</body>
</html>