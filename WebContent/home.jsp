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
<title>Principal</title>
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
	
	
	
		<img class="img col-md-5" alt="Imagem Responsiva" src="../resources/imagens/fundo.jpg" >


<a class="btn btn-default" href="index.html">
	Efetuar Login
</a>

	<a href="loginFormulario"> Efetuar Login </a> <br/>
	<a href="inserirUsuarioFormulario"> Cadastrar-se </a> <br/><br/><br/>
	<center>
		<h3><a href = "listarSecao"> Listar Seções</a></h3><br/>
		<h3><a href = "listarNoticia"> Listar Noticias</a></h3><br/>
		<h3><a href = "listarClassificado"> Listar Classificados</a></h3><br/>
	</center>


<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>