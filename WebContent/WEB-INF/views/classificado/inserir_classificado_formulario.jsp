<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inserir Classificado</title>
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet"> 
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/carousel.css" rel="stylesheet">
<link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<script src="resources/js/ie-emulation-modes-warning.js"></script>
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
	     
	    <!-- CABEÇALHO -->
	    <div class="row">
	     	<div class="col-md-4"></div>
	 	 	<span style="background-color: black;" class="label label-success col-md-4"><font size="6">CRIAR CLASSIFICADO</font></span>
	 	 	<div class="col-md-4"></div>
	 	 </div>
	  	<br/><br/><br/><br/>
	  	<div class="col-md-4"></div>
	  	<form class="form-signin col-md-4" action="inserirClassificado" method="post" enctype="multipart/form-data">
	  		<div class="form-group">
					<label for="titulo" class="col-md-2 control-label">Título: </label>
					<div class="col-md-10">
						<input type="text"  id="titulo" class="form-control" placeholder="Título da Seção" name="titulo" required autofocus>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<label for="preco" class="col-md-2 control-label">Preço: </label>
					<div class="col-md-10">
						<div class="input-group">
					      <div class="input-group-addon">R$</div>
					      <input type="number" class="form-control" id="preco" step="0.01" placeholder="Valor" name="preco" required autofocus>
					    </div>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<label for="telefone" class="col-md-2 control-label">Telefone: </label>
					<div class="col-md-10">
						<input type="text"  id="telefone" class="form-control" placeholder="(XX) 9XXXX-XXXX" name="telefone" required autofocus>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<label for="descricao" class="col-md-2 control-label">Descrição: </label>
					<div class="col-md-10">
						<textarea id="descricao" class="form-control" rows="7" placeholder="Descrição do classificado" name="texto" required autofocus></textarea>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<label for="imagem" class="col-md-2 control-label">Imagem: </label>
					<div class="col-md-10">
						<input type="file"  id="imagem" name="imagem" required autofocus>
					</div>
					<input type="hidden" name="usuario_id" value="${usuario_logado.id}">
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<div class="col-md-4"></div>
						<button class="btn btn-success col-md-4" type="submit" ><b>CRIAR</b></button>
					<div class="col-md-4"></div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
				</div>
	  	</form>
		


<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>