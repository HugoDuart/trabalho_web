package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.classes.Comentario;
import br.ufc.classes.Noticia;
import br.ufc.classes.Usuario;
import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.UsuarioDAO;

@Transactional
@Controller
public class ComentarioController 
{

	@Autowired
	@Qualifier(value="comentarioDAO")
	private ComentarioDAO cDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="noticiaDAO")
	private NoticiaDAO nDAO;
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario()
	{
		return "comentario/inserir_comentario_formulario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(@Valid Comentario comentario, BindingResult result,
										Long usuario_id, Long noticia_id)
	{		
		Usuario usuario = this.uDAO.recuperar(usuario_id);
		comentario.setUsuario(usuario);
		
		Noticia noticia = this.nDAO.recuperar(noticia_id);
		comentario.setNoticia(noticia);
		List <Comentario> comentarios = noticia.getComentarios();
		comentarios.add(comentario);
		noticia.setComentarios(comentarios);
		
		this.cDAO.inserir(comentario);

		return "redirect:listarNoticiaDetalhada?id=" + noticia_id;
	}
	
	/*@RequestMapping("/listarComentario")
	public String listarComentario(Model model)
	{
		List<Comentario> comentarios = this.cDAO.listar();
		model.addAttribute("comentarios", comentarios);		
		
		return "comentario/listar_comentario";
	}*/
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id, Long noticia_id)
	{
		this.cDAO.apagar(id);
		return "redirect:listarNoticiaDetalhada?id=" + noticia_id;
	}
	
	/*@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model)
	{
		Comentario comentario = this.cDAO.recuperar(id);
		model.addAttribute("comentario", comentario);
		return "comentario/alterar_comentario_formulario";
	}*/
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario comentario)
	{
		Comentario c = cDAO.recuperar(comentario.getId());
		comentario.setUsuario(c.getUsuario());
		comentario.setNoticia(c.getNoticia());
		this.cDAO.alterar(comentario);
		return "redirect:listarComentario";
	}
	
}
