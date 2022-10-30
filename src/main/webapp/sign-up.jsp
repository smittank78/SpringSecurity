<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-up Page</title>
</head>
<body>
	<form:form action="process-signup" method="post" modelAttribute="signUpDto">
		<table> 
			<tr>
				<td><label for="user">User  </label></td>
				<td><input type="text"  name="UserName" id="user" /></td>
			</tr>
			<tr>
				<td><label for="textName">password  </label></td>
				<td><input type="text" name="Password" id="textName" /></td>
			</tr>
			<tr>
				<td><label for="Role">role  </label></td>
				<td><input type="text" name="Role" id="Role" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="sign-up"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>