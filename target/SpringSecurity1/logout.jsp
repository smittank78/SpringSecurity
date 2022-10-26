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
	<form:form action="logout" method="post">
		<table> 
	
			<tr>
				<td></td>
				<td><input type="submit" value="log-out"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>