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
<title>Principal</title>
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
	                    	<a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Se��es <span class="caret"></span></a>
	                    	<ul class="dropdown-menu">
	                    		<c:if test="${papel == 'editor'}">
	                    			<li><a href="inserirSecaoFormulario">Criar Nova Se��o</a></li>
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
	                		<li><a href="listarSecao">Listar Se��es</a></li>
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
	     
	    <!-- CABE�ALHO -->
	    <div class="row">
	     	<div class="col-md-4"></div>
	 	 	<span style="background-color: black;" class="label label-success col-md-4"><font size="6">DESTAQUES</font></span>
	 	 	<div class="col-md-4"></div>
	 	 </div>
	  	<br/><br/><br/><br/>
	  	<div class="container col-md-9">
	  		<div class="row">
			  	<c:forEach var="n" items="${noticias}"> 
			  		<div class= "container col-md-4" align="center">
			  			<span class="label label-danger" style="font-size: medium;">Noticia</span><br/><br/>
			  			<a href="listarNoticiaDetalhada?id=${n.id}">
			  				<img width="140" height="140"  src="<c:url value="/resources/imagens/noticia/${n.id}.png" />" class="img-circle" alt="">
						</a>
			  			 <br/><br/><br/>
			  			 <span class="label label-primary" style="font-size: medium;">Se��o: ${n.secao.titulo}</span><br/>
			  			 <span class="label label-default" style="font-size: small;">T�tulo: ${n.titulo}</span><br/><br/>
			  		</div>
			  	</c:forEach>
			</div> <br/><br/><br/><br/><br/><br/><br/>
			<div class="row">
				<c:forEach var="c" items="${classificados}">
					<div class= "container col-md-4" align="center">
			  			<span class="label label-danger" style="font-size: medium;">Classificado</span><br/><br/>
			  			<a href="listarClassificadoDetalhado?id_class=${c.id}">
			  				<img width="140" height="140"  src="<c:url value="/resources/imagens/classificado/${c.id}.png" />" class="img-circle" alt="">
						</a>
			  			 <br/><br/><br/>
			  			 <span class="label label-primary" style="font-size: medium;">${c.titulo}</span><br/>
			  			 <b>Pre�o:</b> ${c.preco}<br/>
			  			 <b>Telefone:</b> ${c.telefone} <br/>
			  			 <b>Melhor Oferta:</b> ${c.melhor_oferta}
			  		</div>
				</c:forEach>
			</div>
		</div>
		<!-- INFORMA��ES DE ACESSO -->
	  	<div class="container col-md-3" style="border-left-style: ridge; border-left-color: silver; background-color: silver;" align="center">
		  	<br/>
		  	<span class="label label-danger" style="font-size: medium;">Informa��es de Acesso</span><br/><br/>
		  	<img width="140" height="140"  src="<c:url value="/resources/imagens/usuario/${usuario_logado.id}.png" />" class="img-circle" alt="">
		  	<br/><br/>
		  	<b>
		  		<font color="white">
		  			<c:if test="${papel=='jornalista'}">
		  				Seja bem vindo ao Jornal Super Mario.<br/>
		  				Voc� est� logado como <font color="red">JORNALISTA</font>, esse � um papel muito importante para 
		  				o sucesso do nosso site, voc� � repons�vel por manter o site atualizado com 
		  				as mais recentes noticias do mundo Mario. Voc� pode criar uma noticia de
		  				qualquer se��o e pode apagar e alterar as suas noticias.
		  			</c:if>
		  			<c:if test="${papel == 'editor'}">
		  				Seja bem vindo ao Jornal Super Mario.<br/>
		  				Voc� est� logado como <font color="red">EDITOR</font>, isso significa que voc� tem grandes
		  				poderes, mas lembre-se, com grandes poderes, vem grandes responsabilidades. 
		  				Voc� possui um cargo administrativo, ent�o voc� poder�:<br/>
		  				- Criar, Alterar e Excluir as Se��es.<br/>
		  				- Criar, Alterar e Excluir os Classificados.<br/>
		  				- Contratar jornalistas. <br/>
		  				- Apagar qualquer noticia.<br/>
		  				- Apagar e alterar Usuarios.
		  			</c:if>
		  			<c:if test="${papel == 'leitor'}">
		  				Seja bem vindo ao Jornal Super Mario.<br/>
		  				Voc� est� logado como <font color="red">LEITOR</font>, muito obrigado por confiar no
		  				nosso site. Voc� poder� comentar as noticias postadas por nossos jornalistas, e realizar
		  				ofertas nos classificados do jornal. Divirta-se e mantenha-se sempre informado.
		  			</c:if>
		  		</font>
		  	</b><br/><br/><br/>
		</div>
		<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
		<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
	</div>

<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>