<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


<title>accueil</title>
</head>
<body>

<c:if test="${!empty sessionConnectee }">
	<%@ include file ="headerConnecte.jsp" %>
</c:if>	
<c:if test="${empty sessionConnectee }">
	<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
</c:if>	

	<br>
		<c:forEach var="current" items="${films }">
			<form method ="get" action= "${ pageContext.request.contextPath }/ServletDetailFilm">

				<div onclick="parentElement.submit()" class="film">
					<div class="container"> 
						<div class="row">
							<div class="col-2">
							<img class="rounded float-left" alt="..." src="Affiche/${current.affiche }">
							</div>
							<div class="col-10">
							<input type="hidden" name="id" value="${current.id }">
							<h3>${current.titre }</h3>
							<p>${current.description}</p> 
							</div>
						</div>
				 	</div> 
			 	</div>				
			</form>
			<br><br>
		</c:forEach>
</body>
</html>