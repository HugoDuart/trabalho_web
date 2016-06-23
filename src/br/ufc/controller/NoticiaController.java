package br.ufc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.classes.Comentario;
import br.ufc.classes.Noticia;
import br.ufc.classes.Secao;
import br.ufc.classes.Usuario;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.util.FinalFileUtil;


@Transactional
@Controller
public class NoticiaController 
{
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model)
	{	
		List<Secao> secoes = sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(@Valid Noticia noticia, BindingResult result, Long usuario_id, 
									String secao_titulo,  
									@RequestParam(value="imagem", required=false) MultipartFile imagem)
	{		
		Usuario usuario = this.uDAO.recuperar(usuario_id);
		noticia.setUsuario(usuario);
		Date data = new Date();
		noticia.setData_noticia(data);
		
		Secao secao = this.sDAO.recuperar(secao_titulo);
		noticia.setSecao(secao);

		this.nDAO.inserir(noticia);
		
		noticia = nDAO.recuperar(noticia.getTitulo());
		
		System.out.println(servletContext.getRealPath("/"));
		
		String path = servletContext.getRealPath("/")+"resources/imagens/noticia/"+noticia.getId()+".png";
		//String path = "C:/Users/Neuziran/workspace/trabalho_final/WebContent/resources/imagens/" + noticia.getId() + ".png";
		FinalFileUtil.salvarImagem(path, imagem);
		
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model)
	{
		List<Noticia> noticias = this.nDAO.listar();
		model.addAttribute("noticias", noticias);		
		
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("/listarNoticiaSecao")
	public String listarNoticiaSecao(Model model, Long secao_id)
	{
		Secao s = sDAO.recuperar(secao_id);
		List<Noticia> noticias = s.getNoticias();
		for(Noticia n: noticias)
			//System.out.println(n.getTitulo());
		model.addAttribute("noticias", noticias);
		return "noticia/listar_noticia";
	}
	
	@RequestMapping("/listarNoticiaDetalhada")
	public String listarNoticiaDetalhada(Model model, Long id, Model model2)
	{
		Noticia noticia = nDAO.recuperar(id);
		model.addAttribute("noticia", noticia);
		List<Comentario> coments = noticia.getComentarios();
		for(Comentario c : coments)
			//System.out.println(c.getTexto());
		model2.addAttribute("coments", coments);
		
		return "noticia/listar_noticia_detalhada";
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long id)
	{
		this.nDAO.apagar(id);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id, Model model)
	{
		Noticia noticia = this.nDAO.recuperar(id);
		model.addAttribute("noticia", noticia);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia)
	{
		Noticia n = nDAO.recuperar(noticia.getId());
		noticia.setData_noticia(n.getData_noticia());
		noticia.setSecao(n.getSecao());
		noticia.setUsuario(n.getUsuario());
		noticia.setComentarios(n.getComentarios());
		
		this.nDAO.alterar(noticia);
		return "redirect:listarNoticia";
	}
}
