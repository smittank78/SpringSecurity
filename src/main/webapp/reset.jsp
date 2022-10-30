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
	<form:form action="resetPassword" method="post" modelAttribute="changePassword">
		<table> 
			<tr>
				<td><label for="user">Old-Password  </label></td>
				<td><input type="text"  name="oldPassword" id="user" /></td>
			</tr>
			<tr>
				<td><label for="textName">New-Password  </label></td>
				<td><input type="text" name="newPassword" id="textName" /></td>
			</tr>
			<tr>
				<td><label for="textName">Confirm-Password  </label></td>
				<td><input type="text" name="confirmedPassword" id="textName" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="reset"></td>
			</tr>
		</table>
	</form:form>
	
	<form:form action="home" method="get">
			<input type="submit" value="Home-Page">
	</form:form>
</body>
</html>