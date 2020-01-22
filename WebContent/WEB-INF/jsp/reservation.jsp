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
	
	
	<h1>Mes Réservations</h1>
	
	<c:forEach var="reservation" items="${reservations }">
			
				<ul>
						<li>${reservation.nbPlaces } places pour ${reservation.titre }, séance à ${reservation.horaire}</li>
						
				</ul>
			
		
			
			
		</c:forEach>
	
	

</body>
</html>