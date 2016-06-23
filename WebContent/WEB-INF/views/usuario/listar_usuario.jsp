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
<link href="resources/css/carousel.css" rel="stylesheet">
<link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<script src="resources/js/ie-emulation-modes-warning.js"></script>
<title>Listar Usuario</title>
<style type="text/css">	

	font {
		font-family: cursive;
	}
	
</style>
</head>
<body>

<div class="container col-md-12" 
		style="border-style: ridge; border-color: silver; background-image: url('resources/imagens/fundo.jpg'); ">
		<div class="row">
			 <!-- CAROUSEL -->
			 <div class="carousel slide" id="myCarousel" data-ride="carousel" >
				 <ol class="carousel-indicators">
					 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					 <li  data-target="#myCarousel" data-slide-to="1"></li>
					 <li data-target="#myCarousel" data-slide-to="2"></li>
				 </ol>
				 <div class="carousel-inner" role="listbox">
					<div class="item active">
						<img class="first-slide" alt="First slide" src="resources/imagens/capa.jpg">
					</div>
					<div class="item">
						<img class="second-slide" alt="Second slide" src="resources/imagens/im2.jpg">
					</div>
					<div class="item">
						<img class="third-slide" alt="Third slide" src="resources/imagens/im3.jpg">
					</div>
				 </div>
			 </div>
		</div>
		<!-- NAVBAR -->
		<div class="navbar-wrapper">
	    	<nav class="navbar navbar-inverse navbar-fixed-top">
	    		<div class="navbar-header">
		    		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		                <span class="sr-only">Toggle navigation</span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
		                <span class="icon-bar"></span>
              		</button>
              		<a class="navbar-brand" href="">Jornal Super Mario</a>
	    		</div>
	    		<div id="navbar" class="navbar-collapse collapse">
		    		<ul class="nav navbar-nav">
		    			<c:if test="${usuario_logado.id == null}">
	               			<li class="active"><a href="telaPrincipal">Tela Principal</a></li>
	               		</c:if>
	               		<c:if test="${usuario_logado.id != null}">
	               			<li class="active"><a href="menu">Tela Principal</a></li>
	               		</c:if>
	                	<li class="dropdown">
	                    	<a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Seções <span class="caret"></span></a>
	                    	<ul class="dropdown-menu">
	                    		<c:if test="${papel == 'editor'}">
	                    			<li><a href="inserirSecaoFormulario">Criar Nova Seção</a></li>
	                    		</c:if>
			                    <c:forEach var="s" items="${secoes}">
			                    	<li><a href="listarNoticiaSecao?secao_id=${s.id}">${s.titulo}</a></li>
			                    </c:forEach>
                 			</ul>
               			</li>
	                	<li><a href="listarClassificado">Classificados</a></li>
	                	<c:if test="${papel == 'jornalista'}">
	                		<li><a href="inserirNoticiaFormulario">Criar Noticia</a></li>
	                	</c:if>
	                	<c:if test="${papel == 'editor'}">
	                		<li><a href="inserirClassificadoFormulario">Criar Classificado</a></li>
	                		<li><a href="listarUsuario">Listar Usuarios</a></li>
	                		<li><a href="listarSecao">Listar Seções</a></li>
	                	</c:if>
            		 </ul>
            		 <ul class="nav navbar-nav navbar-right">
            		 	<c:if test="${usuario_logado.id != null}">
	                		<li><a href="logout">Logout</a></li>
	                		<li><a href="">.</a>
	                	</c:if>
	                	<c:if test="${usuario_logado.id == null}">
	                		<li><a href="loginFormulario">Login</a></li>
	                		<li><a href="inserirUsuarioFormulario">Cadastrar-se </a></li>
	                		<li>..</li>
	                	</c:if>
            		 </ul>
	    		</div>
	    	</nav>
	    </div>
	    <!-- FIM NAVBAR -->
	    <div class="row">
	     	<div class="col-md-4"></div>
	 	 	<span style="background-color: black;" class="label label-success col-md-4"><font size="6">USUARIOS</font></span>
	 	 	<div class="col-md-4"></div>
	 	 </div>
	  	<br/><br/><br/><br/>
		    <c:forEach var="usuario" items="${usuarios}">
			    <div class= "container col-md-4" align="center"><br/>
				    <img width="140" height="140"  src="<c:url value="/resources/imagens/usuario/${usuario.id}.png" />" class="img-circle" alt="">
					<br/>
					<span class="label label-primary" style="font-size: medium;">${usuario.nome}</span><br/>
					<b>Email :</b> ${usuario.email}<br/>
					<b>Login :</b> ${usuario.login}<br/>
					<a class="btn btn-xs btn-warning" href="alterarUsuarioFormulario?id=${usuario.id}">ALTERAR</a>
					<a class="btn btn-xs btn-danger" href="apagarUsuario?id=${usuario.id}&id_logado=${usuario_logado.id}">APAGAR</a>
				</div>
			</c:forEach>
	    <div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
	    <div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
</div>

<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>