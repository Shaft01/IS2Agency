<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos Aranzmana</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/styles.css">

</head>
<body>
	<ul>
	<li><a href="/Agencija/index.jsp">Pocetna</a></li>
	<sec:authorize access="hasRole('ADMIN')">

     <li><a href="/Agencija/unosDestinacije.jsp">Unos destinacije</a></li>
     <li><a href="/Agencija/Unos/getDestinacije">Unos hotela</a></li>
     <li><a href="/Agencija/prikazHotela.jsp">Svi aranzmani hotela</a></li>
    
   
	</sec:authorize>

 <sec:authorize access="hasRole('KORISNIK')or hasRole('ADMIN')">
 
   <li><a href="/Agencija/Agencija/getDestinacije">Rezervisi aranzman</a></li>
   <li><a href="/Agencija/Aranzman/getAranzmaniKorisnika">Pregledaj aranzmane</a></li>
   <li><a href="/Agencija/Agencija/pregledajDestinacije">Pregledaj destinacije</a>
   <li><a href="/Agencija/auth/logout">Odjava</a></li>
 
 </sec:authorize>
 </ul>
	<p>Popunite podatke za aranzman:</p>
	<form action="/Agencija/Agencija/saveAranzman" method="post">
		<table>
			<tr>
			<td>Unesite datum rezervacije:</td>
			<td><input type="date" name="datumRezervisanja"></td>
			</tr>
			<tr>
				<td>Unesite datum placanja:</td>
				<td><input type="date" name="datumPlacanja"></td>
			</tr>
			<tr>
				<td>Odaberite koliko dana zelite da ostanete:</td>
				<td><input type="number" name="brDana" min="1" max="10"></td>
			</tr>
			<tr>
			<td> Odaberite sobu</td>
			<td><select name="idSobe">
				<c:forEach items="${sobe }" var="s">
					<option value="${s.idSoba }">${s.tip } cena: ${s.cena }</option> 
				</c:forEach>
			</select></td>
		</table>
		<input type="submit" value="Rezervisi">
	</form>
	<h3>${poruka }</h3>
</body>
</html>