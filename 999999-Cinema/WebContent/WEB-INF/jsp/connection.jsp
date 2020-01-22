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
<title>Connection</title>
</head>
<body>
<c:if test="${!empty sessionConnectee }">
	<%@ include file ="headerConnecte.jsp" %>
</c:if>	
<c:if test="${empty sessionConnectee }">
	<jsp:include page="/WEB-INF/jsp/headerNonConnecte.jsp"></jsp:include>
</c:if>	
	<h1>Connection</h1>
	
	<div style="border:solid;width:80%;height:200px;margin-left:auto;margin-right:auto;padding:20px; ">
	<form style="margin-left:auto; margin-right:auto;width: 100%;" method="post" action="${pageContext.request.contextPath }/ServletConnexion">
		<p>Identifiant : <input type="text" name="identifiant" placeholder="identifiant"/></p>
		<p>Mot de passe : <input type="password" name="motDePasse" placeholder="******"/></p>
		<input  type="submit" value="Connection">
	
	</form>
	
	
	</div>
</body>
</html>