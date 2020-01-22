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

.film:hover{
	/* background-color : #e5e0df; */
	opacity: 60%;
}

img{
	width: 100px;
	height: 150px;
	float: left;
	margin-right: 20px;

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




	<h1 style="font-size:30px;margin:20px;">Accueil</h1>
	
	
		<c:forEach var="current" items="${films }">
			
			<form method ="get" action= "${ pageContext.request.contextPath }/ServletDetailFilm">
			 
				<div onclick="parentElement.submit()" class="film" style="border:solid;width:80%;height:150px;margin:20px;padding:10px;"> 
					
						<img src="Affiche/${current.affiche }">
						<input type="hidden" name="id" value="${current.id }">
						<h3>${current.titre }</h3>
						<p>${current.description}</p>
					
			 	</div> 
			
				
			</form>
			

		</c:forEach>
		
	
	
</body>
</html>