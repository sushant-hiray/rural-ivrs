<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rural Ivrs | Registration Form</title>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Rural Ivrs | Registration Form | Step 1</div>
<br><br>
<form:form id="registerForm" command="USER">
<table width="400px" height="150px">
<tr>
<td><form:label path="adminName">Name:</form:label></td>
<td><form:input  path="adminName"/></td>
</tr>
<tr>
<td><form:label path="mobileNumber">Mobile Number:</form:label></td>
<td><form:input  path="mobileNumber"/></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Register" />
</td></tr>
</table>
</form:form>
<br>
<a href="login.html" >Click Here to see User List</a>
</center>
</body>
</html>