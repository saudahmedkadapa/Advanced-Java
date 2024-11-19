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
<table border='2'>
<tr>
   <th>Name</th>
   <th>Email</th>
   <th>gender</th>
   <th>Profession</th>
   <th>actions</th>
</tr>
<c:forEach var="userdata" items="${ulist}">
   <tr>
      <td>${userdata.name}</td>
      <td>${userdata.email}</td>
      <td>${userdata.gender}</td>
      <td>${userdata.profession}</td>
      <td>
         <a href="deleteuser/${userdata.name}">delete</a>/
         
         <a href="edituser/${userdata.name}">edit</a>/
         <a href="#">view</a>
      </td>
   </tr>
</c:forEach>
</table>
<a href="register">add new User</a>
</body>
</html>