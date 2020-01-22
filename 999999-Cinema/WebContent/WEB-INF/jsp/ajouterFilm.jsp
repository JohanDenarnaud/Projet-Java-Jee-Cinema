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

<title>ajouter un film</title>
</head>
<body>
<c:if test="${!empty sessionConnectee }">
	<%@ include file ="headerConnecte.jsp" %>
</c:if>	
<c:if test="${empty sessionConnectee }">
	<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
</c:if>	

<h1>Gestion des films</h1>

<h2>Ajouter un film</h2>

<form method="post" action="${pageContext.request.contextPath }/ServletAjouterFilm">

	<input type="text" name="titre" placeholder="Titre"><br><br>
	<textarea type="text" name="description" rows="6" cols="30" placeholder="Description"></textarea><br><br>
	<input type="text" name="dateSortie" placeholder="Date de sortie"><br><br>
	<input type="number" name="duree" placeholder="Durée"><br><br>
	<input type="text" name="affiche" placeholder="affiche"><br><br>
	<input type="submit" value="Ajouter">

</form>

<h2>Modifier / Supprimer un film</h2>

<table style ="border: solid; border-color:grey;">
	<tr style="border:solid; border-color:grey;">
		<th>id</th>
		<th>Titre</th>
		<th>Date de sortie</th>
		<th>Durée</th>
		<th>Affiche</th>
	</tr>
	
	<c:forEach var="film" items="${films }">
		<tr>
			<td>${film.id}</td>
			<td>${film.titre }</td>
			<td>${film.dateSortie }</td>
			<td>${film.duree }</td>
			<td>${film.affiche }</td>
			<td>
			<form method ="post" action="${pageContext.request.contextPath }/ServletSupprimerFilm">
			<input type="hidden" name="id" value="${film.id }">
			<input type ="submit" value="Supprimer">
			</form>
			</td>
			<td>
			<form method ="post" action="${pageContext.request.contextPath }/ServletModifierFilm">
				<input type ="submit" value="Modifier">
			</form>
			</td>
			
		</tr>
		
	
	</c:forEach>



</table>

</body>
</html>