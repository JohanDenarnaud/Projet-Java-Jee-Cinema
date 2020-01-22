<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"> 
<style>

 *{

    font-family : 'Roboto', sans-serif;
     font-size : 20px ;
     
			}
h1{
	font-size:30px;
	margin:20px;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<c:if test="${!empty sessionConnectee }">
		<%@ include file ="headerConnecte.jsp" %>
	</c:if>	
	<c:if test="${empty sessionConnectee }">
		<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
	</c:if>	
	
	<h1>${ film.titre }</h1>
	
	<p>Description : ${ film.description }</p>
	<p>Duree : ${ film.duree } </p>
	<p>Date de sortie : ${ film.dateSortie }</p>
	
	
	
	<h2>Séances</h2>
	
	
	<table border="1">
	
		<tr>
				<th>Séance</th>
				<c:if test="${!empty sessionConnectee }">
				<th> Nombre de tickets </th>
				<th> Actions </th>
				</c:if>
		</tr>
				
		<c:forEach var="seance" items="${film.seances }">
			<form method="post" action="${pageContext.request.contextPath }/ServletReservation">
			<input type ="hidden" name="titreFilm" value="${film.titre }">
			<input type ="hidden" name="horaireFilm" value="${seance.horaire }">
				<tr>
						<td>${seance.horaire } en salle ${seance.salle }</td>
						<c:if test="${!empty sessionConnectee }">
							<td>
								<input type="number" min="0" id="nbPlaces" name="nbPlaces">
							</td>
							<td>
							
								<input type="submit" value="Acheter">
							
							</td>
						</c:if>	
				</tr>
			
			</form>
			
			
		</c:forEach>
		
		
	</table>
	
	
	

</body>
</html>