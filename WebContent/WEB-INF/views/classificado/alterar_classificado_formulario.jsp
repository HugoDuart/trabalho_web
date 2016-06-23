<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Classificado</title>
</head>
<body>
<center>
	<h2>Alterar Classificado : ${classificado.titulo}</h2><br/>

	<form action="alterarClassificado" method="post">
		<input type="hidden" name="id" value="${classificado.id}" />
		<input type="hidden" name="usuarioId" value="${classificado.usuarioId}" />
		<input type="hidden" name="melhor_oferta" value="${classificado.melhor_oferta}" />
		Título: <input type="text" name="titulo" value="${classificado.titulo}"/> <br/><br/>
		Texto: <input type="text" name="texto" value="${classificado.texto}"/> <br/><br/>
		Preço: <input type="number" name="preco" value="${classificado.preco}"/> <br/><br/>
		Telefone: <input type="text" name="telefone" value="${classificado.telefone}"/> <br/><br/>
		<input type="submit" value="ALTERAR"/>
	</form><br/><br/>
	<form action= "listarNoticia" method= "post">
		<input type= "submit" value= "VOLTAR"/>
	</form>
</center>
</body>
</html>