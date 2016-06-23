<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet"> 
<link href="resources/css/style.css" rel="stylesheet">
<title>Criando uma nova noticia</title>
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

	<div class="col-md-3"></div>
	<div class="container col-md-6">
		<div class="row">
			<form class="form-signin col-md-12" action="inserirNoticia" method="post" enctype="multipart/form-data">
				<div class="row">
					<h2 class="form-signin-heading col-md-8"><font>Criar Nova Noticia</font></h2><br/>
					<div class="col-md-4"></div>
				</div>
				<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
				<div class="row">
				    <div class="col-md-4"></div>
					<label for="secoes" class="col-md-6 control-label">Escolha uma Seção</label>
					<div class="col-md-2"></div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<select class="form-control col-md-2" name="secao_titulo" id="secoes">
							<c:forEach var="s" items="${secoes}">
								<option>
									<c:out value="${s.titulo}"></c:out>
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-4"></div>
				</div>
				<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
				<div class="form-group">
					<label for="titulo" class="col-md-2 control-label">Título: </label>
					<div class="col-md-10">
						<input type="text"  id="titulo" class="form-control" placeholder="Título da Noticia" name="titulo" required autofocus>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<label for="subtitulo" class="col-md-2 control-label">SubTítulo: </label>
					<div class="col-md-10">
						<input type="text"  id="subtitulo" class="form-control" placeholder="SubTítulo da Noticia" name="subtitulo" required autofocus>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<label for="texto" class="col-md-2 control-label">Texto: </label>
					<div class="col-md-10">
						<textarea id="texto" class="form-control" rows="7" placeholder="Descrição da Noticia" name="texto" required autofocus></textarea>
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
			</div>
			<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
	</div>
	<div class="col-md-3"></div>
	
<!-- jQuery (necessario para os plugins Javascript Bootstrap) -->
<script src="resources/js/jquery.js"></script> 
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>