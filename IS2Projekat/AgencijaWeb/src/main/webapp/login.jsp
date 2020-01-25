<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles.css">

</head>
<body>
	<c:url var="loginUrl" value="/login" />
 
	<c:if test="${not empty param.error }">
		<p> Invalid username and password </p>
	
	</c:if>
	<div class="login-page">
	  <div class="form">
	<form class="login-form" action="${loginUrl}"   method="post">
	<table>
		<tr>
		<td>Username</td>
		<td><input type="text" name="username" placeholder="Enter username" required></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="password" placeholder="Enter password" required></td>
		</tr>
		
		<tr>
		<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
		
		<td><input type="submit" value="Log in"></td>
		</tr>
		</table>
	
		<a href="/Agencija/register.jsp">Create account</a>
	</form>
	</div>
	</div>
</body>
</html>