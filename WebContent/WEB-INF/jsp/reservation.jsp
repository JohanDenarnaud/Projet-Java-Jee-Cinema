<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${!empty sessionConnectee }">
		<%@ include file ="headerConnecte.jsp" %>
	</c:if>	
	<c:if test="${empty sessionConnectee }">
		<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
	</c:if>	
	
	<div class="container">
	<h1>Mes Réservations</h1>
	
	<c:forEach var="reservation" items="${reservations }">
			
				<ul>
						<li class="list-group-item list-group-item-light">
						${reservation.nbPlaces } places pour ${reservation.titre }, séance à ${reservation.horaire}
						</li>
						
				</ul>
			
		
			
			
		</c:forEach>
	
	</div>
	

</body>
</html>