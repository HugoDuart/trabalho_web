package br.ufc.controller;

import java.util.ArrayList;
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

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.util.FinalFileUtil;
import br.ufc.classes.Papel;
import br.ufc.classes.Usuario;

@Transactional
@Controller
public class UsuarioController 
{

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario()
	{
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(@Valid Usuario usuario, BindingResult result,
			@RequestParam(value="imagem", required=false) MultipartFile imagem)
	{
		if(result.hasFieldErrors("nome"))
		{
			return "usuario/inserir_usuario_formulario";
		}
		
		List <Papel> papeis = new ArrayList<>();
		Papel papel = pDAO.recuperar(1L);
		papeis.add(papel);
		usuario.setPapeis(papeis);
			
		Criptografia crip = new Criptografia();
		usuario.setSenha(crip.criptografar(usuario.getSenha()));
		
		this.uDAO.inserir(usuario);
		usuario = this.uDAO.recuperar(usuario.getLogin());
		
		String path = servletContext.getRealPath("/")+"resources/imagens/usuario/"+usuario.getId()+".png";
		FinalFileUtil.salvarImagem(path, imagem);
		
		return "login_formulario";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model)
	{
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);		
		
		return "usuario/listar_usuario";
	}
	
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id, Long id_logado)
	{
		if(id == id_logado)
		{
			this.uDAO.apagar(id);
			return "redirect:logout";
		}
		this.uDAO.apagar(id);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model)
	{
		Usuario usuario = this.uDAO.recuperar(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario, String papel)
	{
		
		uDAO.atribuirPapel(usuario.getId(), papel);
		Usuario u = uDAO.recuperar(usuario.getId());
		usuario.setComentarios(u.getComentarios());
		usuario.setSenha(u.getSenha());
		usuario.setClassificados(u.getClassificados());
		usuario.setNoticias(u.getNoticias());
		usuario.setPapeis(u.getPapeis());
		this.uDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}
	
}
