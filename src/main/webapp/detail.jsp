<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Page</title>
</head>
<body>
<c:set var="userName"><sec:authentication property="principal.username"/></c:set>
<sec:authorize access="isAuthenticated()">
    Welcome Back,${userName}
</sec:authorize>

<br>
	<form:form action="deleteAcc/${userName}" method="get">
			<input type="submit" value="Delete-Acc">
	</form:form>
	&nbsp;
	<form:form action="changePassword" method="get">
			<input type="submit" value="Change-Password">
	</form:form>
</body>
</html>