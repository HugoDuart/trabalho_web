package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.PapelDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.classes.Usuario;
import br.ufc.classes.Classificado;
import br.ufc.classes.Noticia;
import br.ufc.classes.Papel;
import br.ufc.classes.Secao;

@Controller
public class LoginController 
{
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;

	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private ClassificadoDAO cDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(Model model)
	{
		List<Secao>secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session, String papel, HttpSession session2)
	{
		Criptografia crip = new Criptografia();
		usuario.setSenha(crip.criptografar(usuario.getSenha()));
		
		Usuario candidato = uDAO.recuperar(usuario.getLogin());
		if(candidato != null)
		{
			if(candidato.getSenha().equals(usuario.getSenha()) &&
					pDAO.buscarPapel(candidato.getId(), papel))
			{
				session2.setAttribute("papel", papel);
				session.setAttribute("usuario_logado", candidato);
				return "redirect:menu";
			}
		}
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("/menu")
	public String mostrarMenu(HttpSession session, Model model, Model model2, Model model3)
	{
		List<Secao> secoes = sDAO.listar();
		session.setAttribute("secoes", secoes);
		
		List<Noticia> n = nDAO.listar_recentes();
		List<Noticia> noticias = new ArrayList<>();
		//noticias.add(n.get(0));
		//noticias.add(n.get(1));
		//noticias.add(n.get(2));
		model2.addAttribute("noticias", n);
		
		List<Classificado> c = cDAO.listar_recentes();
		List<Classificado> classificados = new ArrayList<>();
		//classificados.add(c.get(0));
		//classificados.add(c.get(1));
		//classificados.add(c.get(2));
		model3.addAttribute("classificados", c);
		
		return "menu";
	}
	
	@RequestMapping("/telaPrincipal")
	public String telaPrincipal(HttpSession session, Model model, Model model2, Model model3)
	{
		
		List<Noticia> n = nDAO.listar_recentes();
		List<Noticia> noticias = new ArrayList<>();
		//noticias.add(n.get(0));
		//noticias.add(n.get(1));
		//noticias.add(n.get(2));
		model2.addAttribute("noticias", n);
		
		List<Classificado> c = cDAO.listar_recentes();
		List<Classificado> classificados = new ArrayList<>();
		//classificados.add(c.get(0));
		//classificados.add(c.get(1));
		//classificados.add(c.get(2));
		model3.addAttribute("classificados", c);
		
		List<Secao> secoes = sDAO.listar();
		session.setAttribute("secoes", secoes);
		
		return "home";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:telaPrincipal";
	}
}
