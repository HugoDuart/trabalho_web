<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noticias</title>
</head>
<body>

<center><h2>Lista de Noticias</h2></center><br/><br/>

	<c:forEach var="noticia" items="${noticias}">
		<a href="listarNoticiaDetalhada?id=${noticia.id}">
			<h3>Noticia : ${noticia.titulo}</h3>
		</a>
		<h4>${noticia.subtitulo}</h4>
		<a href="alterarNoticiaFormulario?id=${noticia.id}">ALTERAR</a>
		<a href="apagarNoticia?id=${noticia.id}">APAGAR</a>
	</c:forEach><br/><br/>
	
<form action= "menu" method= "post">
	<input type= "submit" value= "VOLTAR AO MENU"/>
</form>
</body>
</html>