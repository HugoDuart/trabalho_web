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
<title>Alterar Noticia</title>
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

<div class="col-md-4"></div>
		<div class="container col-md-4">
			<div class="row">
				<form class="form-signin col-md-12" action="alterarNoticia" method="post">
					<div class="row">
						<h2 class="form-signin-heading col-md-12"><font>Alterando Noticia</font></h2>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<div class="form-group">
						<input type="hidden" name="id" value="${secao.id}" />
						<label for="titulo" class="col-md-3 control-label">Título: </label>
						<div class="col-md-9">
							<input type="text" id="titulo" class="form-control" value="${secao.titulo}" name="titulo" required autofocus>
						</div>
						<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
						<label for="descricao" class="col-md-3 control-label">Descrição: </label>
						<div class="col-md-9">
							<input type="text" id="descricao" class="form-control" value="${secao.descricao}" name="descricao" required autofocus>
						</div>
					</div>
					<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					<div class="row col-md-12">
						<div class="col-md-1"></div>
							<button class="btn btn-success col-md-4" type="submit" ><b>ALTERAR</b></button>
						<div class="col-md-2"></div>
				</form>
						<form action="listarSecao">
							<button class="btn btn-danger col-md-4" type="submit" ><b>VOLTAR</b></button>
						</form>
						<div class="col-md-1"></div>
						<div class="row col-md-12"><font color="#fff">.</font></div> <!-- quebra de linha -->
					</div>
				</div>
			</div>
		</div>
	<div class="col-md-4"></div>

<center>
<h2>Alterar dados da Noticia: ${noticia.titulo}</h2>

<form action="alterarNoticia" method="post">
	<input type="hidden" name="id" value="${noticia.id}" />
	<input type="hidden" name="usuarioId" value="${noticia.usuarioId}" />
	<input type="hidden" name="secaoId" value="${noticia.secaoId}"/> <br/>
	Título: <input type="text" name="titulo" value="${noticia.titulo}"/> <br/>
	SubTítulo: <input type="text" name="subtitulo" value="${noticia.subtitulo}"/> <br/>
	Texto: <textarea rows="20" cols="60" name="texto" > ${noticia.texto} </textarea> <br/>
	<input type="submit" value="ALTERAR"/>
</form><br/><br/>
<form action= "listarNoticia" method= "post">
	<input type= "submit" value= "VOLTAR"/>
</form>
</center>
</body>
</html>