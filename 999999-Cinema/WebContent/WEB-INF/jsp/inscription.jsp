<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <style>

 *{

    font-style : ROBOTO, balck arial, calibri;
     font-size : 20px ;
     
			}
h1{
	font-size:30px;
	margin:20px;
}
</style>
<title>Inscription</title>
</head>
<body>
<c:if test="${!empty sessionConnectee }">
	<%@ include file ="headerConnecte.jsp" %>
</c:if>	
<c:if test="${empty sessionConnectee }">
	<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
</c:if>	
	<h1>Inscription</h1>
	
	<div style="border:solid;width:300px;height:300px;margin:20px;padding:10px;">
	<form method="post" action="${pageContext.request.contextPath }/ServletInscription">
		<p>Identifiant : <input type="text" name="identifiant" placeholder="identifiant"/></p>
		<p>Mot de passe : <input type="password" name="motDePasse" placeholder="******"/></p>
		<p>Confirmation : <input type="password" name="confirmationMP" placeholder="******"/></p>
		<input type="submit" value="Inscription">
	
	</form>
	
	
	</div>
</body>
</html>