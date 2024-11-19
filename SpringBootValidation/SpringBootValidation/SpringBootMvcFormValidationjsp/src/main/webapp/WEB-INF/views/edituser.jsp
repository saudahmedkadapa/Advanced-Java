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
<form:form action="/updatedata" method="post" modelAttribute="myUser">
  <div>
     <form:label path="name">Full name</form:label>
     <form:input path="name" value="${myUser.name}" readonly="true"/>
     <form:errors path="name" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="email">E-mail</form:label>
     <form:input path="email" value="${myUser.email}"/>
     <form:errors path="email" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="gender">gender</form:label>
     <form:radiobutton path="gender" value="Male" checked="${myUser.gender=='Male'}"/>Male
     <form:radiobutton path="gender" value="Female" checked="${myUser.gender=='Female'}"/>female
      <form:errors path="gender" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="profession">Profession</form:label>
     <form:select path="profession" items="${professionList}" value="${myUser.profession}"/>
     <form:errors path="profession" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="birthday">Birth day</form:label>
     <form:input path="birthday" type="date" value="${myUser.birthday}"/>
     <form:errors path="birthday" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="married">Married</form:label>
     <form:checkbox path="married" checked="true"/>
     <form:errors path="married" cssClass="error"/>
  </div>
  
  <div>
     <form:label path="income">Annual Income</form:label>
     <form:input path="income" value="${myUser.income}"/>
     <form:errors path="income" cssClass="error"/>
  </div>
  <div>
     <form:label path="note">Note</form:label>
     <form:input path="note" cols="25" rows="5" value="${myUser.note}"/>
     <form:errors path="note" cssClass="error"/>
  </div>
<div>
     <form:button>Update data</form:button>
    
  </div>
</form:form>
</body>
</html>