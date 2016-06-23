<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classificado</title>
</head>
<body>
<center>
	<h2>Classificado : ${classificado.titulo}</h2><br/>
		Criador = ${classificado.usuario.nome}<br/><br/>
		Título = ${classificado.titulo}<br/><br/>
		Descrição = ${classificado.texto}<br/><br/>
		Preço = ${classificado.preco} <br/><br/>
		Contato = ${classificado.telefone}<br/><br/>
		Data de criação = ${classificado.data_oferta}<br/><br/>
		Melhor Oferta = ${classificado.melhor_oferta} Realizada por = ${comprador.nome} <br/><br/>
		
		<form action="inserirOferta" method="post">
			<input type="hidden" name="id_class" value="${classificado.id}" />
			<input type="hidden" name="id_comprador" value="${usuario_logado.id}" />
			Oferta = <input type="number" step="0.01" name="valor" />
		<input type="submit" value="OFERTAR"/>
		</form><br/><br/>
	<form action= "listarClassificado" method= "post">
		<input type= "submit" value= "VOLTAR"/>
	</form>
</center>
</body>
</html>