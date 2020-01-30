<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<title>ajouter un film</title>
</head>
<body>
	<c:if test="${!empty sessionConnectee }">
		<%@ include file="headerConnecte.jsp"%>
	</c:if>
	<c:if test="${empty sessionConnectee }">
		<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
	</c:if>
	<div class="container">
		<h1>Gestion des films</h1>
		<br>
		<div class="row">
			<div class="col-3">
				<h3>Ajouter un film</h3>
			</div>
			<div class="col-9">

				<h3>Modifier / Supprimer un film</h3>
			</div>
		</div>


		<div class="row">
			<div class="col-3">
				<form method="post"
					action="${pageContext.request.contextPath }/ServletAjouterFilm">
					<div>

						<input class="form-control" type="text" id="titre" name="titre"
							placeholder="Titre">
					</div>
					<br>
					<div>

						<textarea class="form-control" id="description" name="description"
							rows="6" cols="30" placeholder="Description"></textarea>
					</div>
					<br>
					<div>

						<input class="form-control" id="date" type="date"
							name="dateSortie" placeholder="Date de sortie">
					</div>
					<br>
					<div>

						<input class="form-control" id="duree" type="number" name="duree"
							placeholder="Durée">
					</div>
					<br>
					<div>

						<input class="form-control" id="affiche" type="text"
							name="affiche" placeholder="affiche">
					</div>
					<br>
					<button type="submit" class="btn btn-success">Ajouter</button>

				</form>

			</div>

			<div class=col-9>

				<table class="clo-9 table table-striped">
					<tr>
						<th>id</th>
						<th>Titre</th>
						<th>Date de sortie</th>
						<th>Durée</th>
						<th>Affiche</th>
						<th></th>
						<th></th>
					</tr>

					<c:forEach var="film" items="${films }">
						<tr>
							<td>${film.id}</td>
							<td>${film.titre }</td>
							<td>${film.dateSortie }</td>
							<td>${film.duree }</td>
							<td>${film.affiche }</td>
							<td>
								<form method="post"
									action="${pageContext.request.contextPath }/ServletSupprimerFilm">
									<input type="hidden" name="id" value="${film.id }">
									<button type="submit" class="btn btn-danger">Supprimer</button>
								</form>
							</td>
							<td>
								<form method="post"
									action="${pageContext.request.contextPath }/ServletModifierFilm">
									<button type="submit" class="btn btn-primary">Modifier</button>
								</form>
							</td>

						</tr>


					</c:forEach>



				</table>
			</div>
		</div>
	</div>
</body>
</html>