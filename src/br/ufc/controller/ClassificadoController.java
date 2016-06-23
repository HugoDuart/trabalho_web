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

import br.ufc.classes.Classificado;
import br.ufc.classes.Comentario;
import br.ufc.classes.Noticia;
import br.ufc.classes.Secao;
import br.ufc.classes.Usuario;
import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.util.FinalFileUtil;

@Transactional
@Controller
public class ClassificadoController 
{

	@Autowired
	@Qualifier(value="classificadoDAO")
	private ClassificadoDAO cDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(Model model)
	{
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(@Valid Classificado classificado, BindingResult result,
			Long usuario_id, @RequestParam(value="imagem", required=false) MultipartFile imagem)
	{		
		Usuario usuario = this.uDAO.recuperar(usuario_id);
		classificado.setUsuario(usuario);
		classificado.setMelhor_oferta(0.0);
		Date data = new Date();
		classificado.setData_oferta(data);
		
		this.cDAO.inserir(classificado);

		classificado = this.cDAO.recuperar(classificado.getTitulo());
		String path = servletContext.getRealPath("/")+"resources/imagens/classificado/"+classificado.getId()+".png";
		FinalFileUtil.salvarImagem(path, imagem);
		
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model)
	{
		List<Classificado> classificados = this.cDAO.listar();
		model.addAttribute("classificados", classificados);		
		
		return "classificado/listar_classificado";
	}
	
	@RequestMapping("/listarClassificadoDetalhado")
	public String listarClassificadoDetalhado(Model model, Long id_class, Model model2)
	{
		Classificado classificado = cDAO.recuperar(id_class);
		model.addAttribute("classificado", classificado);
		if(classificado.getCompradorId() != null){
			Usuario comprador = uDAO.recuperar(classificado.getCompradorId());
			model2.addAttribute("comprador", comprador);
		}
		return "classificado/listar_classificado_detalhado";
	}
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long id)
	{
		this.cDAO.apagar(id);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/inserirOferta")
	public String inserirOferta(Long id_class, Long id_comprador, Double valor)
	{
		Classificado c = cDAO.recuperar(id_class);
		if(c.getMelhor_oferta() < valor && c.getPreco() <= valor)
		{
			c.setMelhor_oferta(valor);
			c.setCompradorId(id_comprador);
			cDAO.alterar(c);
		}
		return "redirect:listarClassificadoDetalhado?id_class=" + id_class;
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long id, Model model)
	{
		Classificado classificado = this.cDAO.recuperar(id);
		model.addAttribute("classificado", classificado);
		return "classificado/alterar_classificado_formulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado classificado)
	{
		Classificado c = cDAO.recuperar(classificado.getId());
		classificado.setData_oferta(c.getData_oferta());
		classificado.setUsuario(c.getUsuario());
		classificado.setMelhor_oferta(c.getMelhor_oferta());
		this.cDAO.alterar(classificado);
		return "redirect:listarClassificado";
	}
	
}
