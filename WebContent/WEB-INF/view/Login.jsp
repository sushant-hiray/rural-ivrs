<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rural Ivrs | Login</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Rural IVRS | Admin Login</div>
<br><br>
<c:url var="userRegistration" value="checkUser.html"/>
<form:form id="loginForm" modelAttribute="user" method="post" action="${userRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label path="firstName">First Name</form:label></td>
<td><form:input  path="firstName"/></td>
</tr>
<tr>
<td><form:label path="lastName">Password</form:label></td>
<td><form:password  path="lastName"/></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Login" />
</td></tr>
</table>
</form:form>
<br>
<!--  <a href="userList.html" >Click Here to see User List</a> -->
</center>
</body>
</html>