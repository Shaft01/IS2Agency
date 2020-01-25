<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Odabir destinacije</title>
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
	<form action="/Agencija/Agencija/getHoteli" method="get">
		<c:if test="${!empty destinacije }">
			<select name="idDestinacija">
				<c:forEach items="${destinacije }" var="d">
					<option value="${d.idDestinacija }">${d.naziv } </option> 
				</c:forEach>
			</select>
			<input type="submit" value="Prikazi">
		</c:if>
	</form>
	<c:if test="${!empty hoteli }">
	<p>Prikaz hotela za destinaciju ${dest.naziv }</p>
	<table class="greenTable">
	<thead>
		<tr>
			<th>Naziv hotela</th> <th>Broj zvezdica</th> <th>Link</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${hoteli }" var="h">
			<tr>
			<td>${h.naziv }</td><td>${h.brZvezdica }</td>
			<td><a href="/Agencija/Agencija/getSobe?idHotel=${h.idHotel }">Lista soba</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>