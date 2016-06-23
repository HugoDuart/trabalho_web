package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.classes.Usuario;

@Component
public class InterceptadorGeral extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String URI = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_logado");
		String papel = null;
		if(URI.contains("/trabalho_final/resources/")){
			return true;
		}
		
		if(request.getSession().getAttribute("papel") != null){
			papel = (String) request.getSession().getAttribute("papel");
		}
		
		if(URI.endsWith("inserirUsuarioFormulario") || URI.endsWith("inserirUsuario") || URI.endsWith("listarSecao") ||
				URI.endsWith("listarNoticia") || URI.endsWith("listarNoticiaSecao") || URI.endsWith("listarNoticiaDetalhada") ||
				URI.endsWith("loginFormulario") || URI.endsWith("login") || URI.endsWith("telaPrincipal") || URI.endsWith("listarClassificado") ||
				URI.endsWith("listarClassificadoDetalhado") || URI.endsWith("menu")){
			return true;
		}
		
		if(usuario != null){
				if(papel.equals("leitor")){
				if( URI.endsWith("apagarUsuario") || URI.endsWith("alterarUsuarioFormulario") || URI.endsWith("alterarUsuario") || 
						URI.endsWith("inserirComentarioFormulario") || URI.endsWith("inserirComentario") || URI.endsWith("apagarComentario") ||
						URI.endsWith("inserirOferta") ){
					return true;
				}
			}else if(papel.equals("jornalista")){
				if(URI.endsWith("apagarUsuario") || URI.endsWith("alterarUsuarioFormulario") || URI.endsWith("alterarUsuario") ||
						URI.endsWith("inserirNoticiaFormulario") || URI.endsWith("inserirNoticia") || URI.endsWith("apagarNoticia") ||
						URI.endsWith("alterarNoticiaFormulario") || URI.endsWith("alterarNoticia") || URI.endsWith("inserirComentarioFormulario") || 
						URI.endsWith("inserirComentario") || URI.endsWith("apagarComentario") || URI.endsWith("inserirOferta")){
					return true;
				}
			}else{
				if(URI.endsWith("listarUsuario") || URI.endsWith("apagarUsuario") || URI.endsWith("alterarUsuarioFormulario") ||
						URI.endsWith("alterarUsuario") || URI.endsWith("inserirSecaoFormulario") || URI.endsWith("inserirSecao") ||
						URI.endsWith("apagarSecao") || URI.endsWith("alterarSecaoUsuarioFormulario") || URI.endsWith("alterarSecao") ||
						URI.endsWith("apagarNoticia") || URI.endsWith("alterarNoticiaFormulario") || URI.endsWith("alterarNoticia") || 
						URI.endsWith("inserirComentarioFormulario") || URI.endsWith("inserirComentario") || URI.endsWith("apagarComentario") ||
						URI.endsWith("inserirClassificadoFormulario") || URI.endsWith("inserirClassificado") || URI.endsWith("apagarClassificado") ||
						URI.endsWith("inserirOferta") || URI.endsWith("alterarClassificado") || URI.endsWith("alterarClassificadoFormulario")){
					return true;
				}
			}
			response.sendRedirect("telaPrincipal");
			return false;
		}
		
		response.sendRedirect("telaPrincipal");
		return false;
	}
}
