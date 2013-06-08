<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rural Ivrs | Login</title>
<style>
.error {
	color: #ff0000;
}

</style>
<script type="text/javascript" src="<c:url value="/resources/jquery-1.4.min.js" /> "></script>
<script type="text/javascript" src="<c:url value="/resources/json.min.js" /> "></script>
<script type="text/javascript">
$(document).ready(function() {
    // check name availability on focus lost
    $('#username').blur(function() {
        checkAvailability();
    });
});
function checkAvailability() {
    $.getJSON("./checkAvailability", { firstName: $('#username').val() }, function(availability) {
        if (availability) {
            fieldValidated("firstName", { valid : true });
        } else {
            fieldValidated("firstName", { valid : false,
                message : $('#username').val() + " is not available, try something different";
        }
    });
}
</script>

</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Rural IVRS | Admin Login</div>
<br><br>
<c:url var="userRegistration" value="checkUser.html"/>
<form:form id="loginForm" modelAttribute="user" method="post" action="${userRegistration}">
<form:errors path="*" cssClass="error" element="div"/>
<table width="400px" height="150px">
<tr>
<td><form:label path="firstName" >First Name</form:label></td>
<td><form:input  path="firstName" for="firstName" id="username"/></td>
<td><form:errors path="firstName" cssClass="error" /></td>
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