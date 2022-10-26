<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form:form action="process-login" method="post">
		<table> 
			<tr>
				<td><label for="user">User  </label></td>
				<td><input type="text"  name="username" id="user" /></td>
			</tr>
			<tr>
				<td><label for="textName">password  </label></td>
				<td><input type="text" name="password" id="textName" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="log-in"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>