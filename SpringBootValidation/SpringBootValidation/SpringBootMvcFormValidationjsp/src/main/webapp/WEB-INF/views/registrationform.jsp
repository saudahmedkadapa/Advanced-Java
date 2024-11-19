<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
    color:red;
    font-style:italic;
 }
</style>
</head>
<body>
<form:form action="register" method="post" modelAttribute="myUser">
  <div>
     <form:label path="name">Full name</form:label>
     <form:input path="name"/>
     <form:errors path="name" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="email">E-mail</form:label>
     <form:input path="email"/>
     <form:errors path="email" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="gender">gender</form:label>
     <form:radiobutton path="gender" value="Male"/>Male
     <form:radiobutton path="gender" value="Female"/>female
      <form:errors path="gender" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="profession">Profession</form:label>
     <form:select path="profession" items="${professionList}"/>
     <form:errors path="profession" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="birthday">Birth day</form:label>
     <form:input path="birthday" type="date"/>
     <form:errors path="birthday" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="married">Married</form:label>
     <form:checkbox path="married"/>
     <form:errors path="married" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="income">Annual Income</form:label>
     <form:input path="income"/>
     <form:errors path="income" cssClass="error"/>
  </div>
  <div>
     <form:label path="note">Note</form:label>
     <form:input path="note" cols="25" rows="5"/>
     <form:errors path="note" cssClass="error"/>
  </div>
<div>
     <form:button>Register me</form:button>
    
  </div>
</form:form>

</body>
</html>