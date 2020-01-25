<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos Hotela</title>
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
	<form action="/Agencija/Unos/unosHotela" method="post">
	<table>
		<tr>
			<td>Ime hotela:</td>
			<td><input type="text" name="naziv"></td>
		</tr>
		<tr>
			<td>Broj zvezdica:</td>
			<td><input type="number" name="brZvezdica" min="1" max="5"></td>
		</tr>
		<tr>
		<td>Destinacija</td>
		<td><select name="destinacija" >
					<c:forEach items="${destinacije}" var ="d">
						<option value = "${d.idDestinacija}">${d.naziv}</option>
					</c:forEach>
				</select></td>
		</tr>
		<tr><td><input type = "submit"  value = "Dodaj"></td></tr>
		
		</table>
	 </form>
	 
	 <h3>${poruka }</h3>
</body>
</html>