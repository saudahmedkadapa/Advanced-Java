<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--this is dummy payment page to do the payment of order 
it will take you to logout page--%>
<%String btn=request.getParameter("btn");
  if(btn.equals("pay")){%>
  <form action="logoutpage.jsp">
    Amount: ${param.amt }
    Credit card number: <input type="text" name="cnum" id="cnum"></input>
	<button type="submit" name="btn" id="btn">Pay amount</button>
	</form>  
 <% }else{%>
	  <jsp:forward page="findcategory"></jsp:forward>
  <%}
%>
</body>
</html>