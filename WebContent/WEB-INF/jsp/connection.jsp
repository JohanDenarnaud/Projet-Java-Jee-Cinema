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

<title>Connection</title>
</head>
<body>
<c:if test="${!empty sessionConnectee }">
	<%@ include file ="headerConnecte.jsp" %>
</c:if>	
<c:if test="${empty sessionConnectee }">
	<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
</c:if>	
	
	<div class = "container connection" >
	<h1>Connection</h1>
	
	
	<form  method="post" action="${pageContext.request.contextPath }/ServletConnexion">
		<div class="form-group">
			<label for="identifiant">Identifiant</label>
			<input class="form-control" type="text" id="identifiant" name="identifiant" placeholder="identifiant"/>
		</div>
		
		<div class="form-group">
			<label for="password">Mot de passe</label>
			<input class="form-control" type="password" id="password" name="motDePasse" placeholder="********"/>
		</div>
		
		<button type="submit" class="btn btn-secondary">M'identifier</button>
		
	
	</form>
	
	
	</div>
	
</body>
</html>