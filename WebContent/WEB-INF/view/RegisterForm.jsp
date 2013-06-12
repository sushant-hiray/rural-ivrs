<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rural Ivrs | Registration Form</title>

<style>
.error {
	color: #ff0000;
}
.highlight { background:yellow; }

</style>
<script type="text/javascript" src="<c:url value="/resources/jquery-1.4.min.js" /> "></script>
<script type="text/javascript" src="<c:url value="/resources/json.min.js" /> "></script>
<script type="text/javascript">
$(document).ready(function() {
    // check name availability on focus lost
    $('#username').blur(function() {
    	doAjax();
        
    });
    
});

function doAjax() {
  $.ajax({
    url: 'person.html',
    data: ({name : $("#username").val()}),
    success: function(data) {
    if(data=="false")
      $('#time').html("username is not available");
    else
    	$('#time').html("username is available");
    }
  });
}
</script>


</head>
<body>
<center>
<br><br><br><br><br><br>
<div style="color: teal;font-size: 30px">Rural IVRS | Register | Step 2</div>
<br><br>
<c:url var="userRegistration" value="confirm.html"/>
<form:form id="registerForm2" modelAttribute="user" method="post" action="${userRegistration}">
<table width="400px" height="150px">
<tr>
<td><form:label  path="admin.username">User Name:</form:label></td>
<td><form:input id="username" for="username" path="admin.username"/><div id="time" style="text-color:red">
</div></td>
<td><form:errors path="admin.username" cssClass="error" /></td>
</tr>
<tr>
<td><form:label path="admin.password">Password</form:label></td>
<td><form:input id="password" path="admin.password"/></td>
<td><form:errors path="admin.password" cssClass="error" /></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Confirm" />
</td></tr>
</table>
</form:form>

</center>
</body>
</html>