package br.ufc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.classes.Usuario;

@WebFilter("/*")
public class AutorizadorFiltro implements Filter
{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{		
		
		String URI = ((HttpServletRequest)request).getRequestURI();
		
		System.out.println("URI: " + URI);
		
		
		Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario_logado");
		String papel = null;
		
		if(URI.startsWith("/trabalho_final/resources")){
			chain.doFilter(request, response);
			return;
		}
		
		if(((HttpServletRequest) request).getSession().getAttribute("papel") != null){
			papel = (String) ((HttpServletRequest) request).getSession().getAttribute("papel");
		}
		
		if(URI.endsWith("inserirUsuarioFormulario") || URI.endsWith("inserirUsuario") || URI.endsWith("listarSecao") ||
				URI.endsWith("listarNoticia") || URI.endsWith("listarNoticiaSecao") || URI.endsWith("listarNoticiaDetalhada") ||
				URI.endsWith("loginFormulario") || URI.endsWith("login") || URI.endsWith("telaPrincipal") || URI.endsWith("listarClassificado") ||
				URI.endsWith("listarClassificadoDetalhado") || URI.endsWith("logout")){
			chain.doFilter(request, response);
			return;
		}
		
		if(usuario != null){
			if(papel.equals("leitor")){
			if( URI.endsWith("apagarUsuario") || URI.endsWith("alterarUsuarioFormulario") || URI.endsWith("alterarUsuario") || 
					URI.endsWith("inserirComentarioFormulario") || URI.endsWith("inserirComentario") || URI.endsWith("apagarComentario") ||
					URI.endsWith("inserirOferta") || URI.endsWith("menu") ){
				chain.doFilter(request, response);
				return;
			}
		}else if(papel.equals("jornalista")){
			if(URI.endsWith("apagarUsuario") || URI.endsWith("alterarUsuarioFormulario") || URI.endsWith("alterarUsuario") ||
					URI.endsWith("inserirNoticiaFormulario") || URI.endsWith("inserirNoticia") || URI.endsWith("apagarNoticia") ||
					URI.endsWith("alterarNoticiaFormulario") || URI.endsWith("alterarNoticia") || URI.endsWith("inserirComentarioFormulario") || 
					URI.endsWith("inserirComentario") || URI.endsWith("apagarComentario") || URI.endsWith("inserirOferta") || URI.endsWith("menu")){
				chain.doFilter(request, response);
				return;
			}
		}else{
			if(URI.endsWith("listarUsuario") || URI.endsWith("apagarUsuario") || URI.endsWith("alterarUsuarioFormulario") ||
					URI.endsWith("alterarUsuario") || URI.endsWith("inserirSecaoFormulario") || URI.endsWith("inserirSecao") ||
					URI.endsWith("apagarSecao") || URI.endsWith("alterarSecaoUsuarioFormulario") || URI.endsWith("alterarSecao") ||
					URI.endsWith("apagarNoticia") || URI.endsWith("alterarNoticiaFormulario") || URI.endsWith("alterarNoticia") || 
					URI.endsWith("inserirComentarioFormulario") || URI.endsWith("inserirComentario") || URI.endsWith("apagarComentario") ||
					URI.endsWith("inserirClassificadoFormulario") || URI.endsWith("inserirClassificado") || URI.endsWith("apagarClassificado") ||
					URI.endsWith("inserirOferta") || URI.endsWith("alterarClassificado") || URI.endsWith("alterarClassificadoFormulario") || 
					URI.endsWith("menu")){
				chain.doFilter(request, response);
				return;
			}
		}
		((HttpServletResponse) response).sendRedirect("logout");
		//((HttpServletResponse) response).sendRedirect("telaPrincipal");
		return;
		}
		((HttpServletResponse) response).sendRedirect("logout");
		//((HttpServletResponse) response).sendRedirect("telaPrincipal");
		return;
		
		
	/*	
		if(uri.endsWith("loginFormulario") || uri.endsWith("login")|| uri.endsWith("inserirUsuarioFormulario")|| 
				uri.endsWith("inserirUsuario") || uri.endsWith("telaPrincipal"))
		{
			chain.doFilter(request, response);
		}
		else if(((HttpServletRequest) request).getSession().getAttribute("usuario_logado")!= null)
		{
			chain.doFilter(request, response);
		}
		else if((uri.startsWith("/trabalho_final/resources/")))
		{
			chain.doFilter(request, response);
		}
		else if(uri.endsWith("listarNoticia") || uri.endsWith("listarNoticiaDetalhada"))
		{
			chain.doFilter(request, response);
		}
		else if(uri.endsWith("listarSecao") || uri.endsWith("listarNoticiaSecao"))
		{
			chain.doFilter(request, response);
		}
		else if(uri.endsWith("listarClassificado") || uri.endsWith("listarClassificadoDetalhado"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("telaPrincipal");
		}
*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
