<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>       
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz aranzmana korisnika</title>
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
	<p>Prikaz aranzmana za korisnika ${korisnik.ime } ${korisnik.prezime }</p>
	
	<table class="greenTable">
	<thead>
		<tr><th>Destinacija</th><th>Hotel</th><th>Soba</th><th>Cena aranzmana</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${aranzmani }" var="a">
		<tr>
			<td>${a.destinacija.naziv }</td>
			<td>${a.hotel.naziv }</td>
			<td>${a.soba.tip }</td>
			<td>${a.cena}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<form action="/Agencija/Aranzman/izvestaj" method="get">
	<input type="submit" value="Izvestaj">
	</form>
</body>
</html>