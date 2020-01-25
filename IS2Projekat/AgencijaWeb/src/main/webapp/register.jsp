<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles.css"> 

</head>
<body>
<div class="login-page">
<div class="form">
<form  class="login-form" action="/Agencija/auth/register"  method="post">
  
  	   Ime:<input type="text" name="ime"/>
  		Prezime<input type="text" name="prezime"/>
  		
  		Email<input type="text" name="email"/>
  		Korisnicko ime:<input type="text" name="username"/>
  	>Sifra:<input type="password" name="password"/>
  	  	
  	<input type="submit" value="Registruj se">
  	
</form>
</div>
</div>
</body>
</html>