<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%int n=Integer.parseInt(request.getParameter("num1"));
  String msg="";
    if(n<=5){
    	msg="then number is small";
    }else{
    	msg="then number is big";
    }
    	
  %>
  <h1>This is getdata page</h1>
    <%-- <jsp:forward page="displaydata.jsp">
        <jsp:param name="message" value="<%=msg%>"></jsp:param>
    </jsp:forward> --%> 
    <jsp:include page="displaydata.jsp">
        <jsp:param name="message" value="<%=msg%>"></jsp:param>
    </jsp:include>
 
</body>
</html>