<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet"> 
<link href="resources/css/style.css" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
	body{
		background-image: url("resources/imagens/background.jpg") ;
		background-repeat: no-repeat;
		background-attachment: fixed;
	}
	.container{
		background-image: url("resources/imagens/fundo.jpg");
		border-style: ridge;
		border-color: silver;
	}
	font {
		font-family: cursive;
	}
	
</style>
</head>
<body>


<img class="img col-md-5" alt="Imagem Responsiva" src="<c:url value="/resources/imagens/${noticia.id}.png" />" />

<h2>${noticia.id }</h2>
	<img alt="${noticia.titulo}" src="resources/imagens/${noticia.id}.png" />
	<h2>${noticia.titulo}</h2><br/>
	<h4>${noticia.subtitulo}</h4><br/>
	<h6>${noticia.texto}</h6><br/>
	Enviada por : ${noticia.usuario.nome} em: ${noticia.data_noticia}<br/><br/>
	<h3>Comentários</h3>
<br/><br/>
<c:if test="${usuario_logado != null}">
	<form action= "inserirComentario" method= "post">
		Comentar: <input type="text" name="texto"/>
		<input type="hidden" name="usuario_id" value="${usuario_logado.id}">
		<input type="hidden" name="noticia_id" value="${noticia.id}">
		<input type= "submit" value= "ENVIAR"/>
	</form>
</c:if><br/>
	<c:forEach var="c" items="${coments}">
		${c.texto}
		<b>${c.usuario.nome}</b> 
		<c:if test="${papel == 'editor' || c.usuario.id == usuario_logado.id}">
			<a href="apagarComentario?id=${c.id}&noticia_id=${noticia.id}">APAGAR</a>
		</c:if>
		<br/>
	</c:forEach><br/><br/>
<center>
	<form action= "listarNoticia" method= "post">
		<input type= "submit" value= "VOLTAR"/>
	</form>
</center>

<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>