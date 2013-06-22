<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rural Ivrs | Registration Form</title>
<style>
.error {
	color: #ff0000;
}

</style>
<script>
$(document).ready(function() {
	$("#masala").val("${admin}");
});
</script>
</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Rural Ivrs | Registration Form | Step 2</div>
<br><br>
<c:url var="userreg" value="saveUser.html"/>
<jsp:setProperty name="user" property="id" value="${id}"/>
<table border="1" bgcolor="black" width="600px">
<tr style="background-color: teal;color: white;text-align: center;" height="40px">
<td>First Name</td>
<td>Last Name</td>
</tr>
<tr style="background-color:white;color: black;text-align: center;" height="30px" >
<td><c:out value="${admin.username}"/></td>
<td><c:out value="${id}"/></td>
</tr>
</table>
<br>
<form:form id="registerForm" modelAttribute="user" method="post" action="${userreg}">
<table width="400px" height="150px">
<tr>
<td><form:label path="adminDetails.adminName">Name:</form:label></td>
<td><form:input  path="adminDetails.adminName"/></td>
<td><form:errors path="adminDetails.adminName" cssClass="error" /></td>
</tr>
<tr>
<td><form:label path="adminDetails.mobileNumber">Mobile Number:</form:label></td>
<td><form:input  path="adminDetails.mobileNumber"/></td>
<td><form:errors path="adminDetails.mobileNumber" cssClass="error" /></td>
</tr>
<tr>
<td><form:label path="adminDetails.emailId">Email Id:</form:label></td>
<td><form:input  path="adminDetails.emailId"/></td>
<td><form:errors path="adminDetails.emailId" cssClass="error" /></td>
</tr>
<tr>
<td>
<form:hidden path="id" />
</td>
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