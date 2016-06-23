<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classificados</title>
</head>
<body>
<center>
	<h2>Lista de Classificados</h2>
</center><br/>
	<c:forEach var="classificado" items="${classificados}">
		<a href="listarClassificadoDetalhado?id_class=${classificado.id}">
			<h3>Classificado : ${classificado.titulo}</h3>
		</a>
		Descrição : ${classificado.texto}<br/><br/>
		<a href="alterarClassificadoFormulario?id=${classificado.id}">ALTERAR</a>
		<a href="apagarClassificado?id=${classificado.id}">APAGAR</a>
	</c:forEach><br/><br/>
<center>
	<form action= "menu" method= "post">
		<input type= "submit" value= "VOLTAR AO MENU"/>
	</form>
</center>
</body>
</html>