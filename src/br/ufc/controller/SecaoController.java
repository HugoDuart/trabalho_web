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

import br.ufc.classes.Secao;
import br.ufc.dao.SecaoDAO;

@Transactional
@Controller
public class SecaoController 
{

	@Autowired
	@Qualifier(value="secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(Model model2)
	{
		List<Secao> secoes = sDAO.listar();
		model2.addAttribute("secoes", secoes);
		return "secao/inserir_secao_formulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(@Valid Secao secao, BindingResult result)
	{		
		this.sDAO.inserir(secao);

		return "redirect:listarSecao";
	}
	
	@RequestMapping("/listarSecao")
	public String listarSecao(Model model)
	{
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);		
		
		return "secao/listar_secao";
	}
	
	@RequestMapping("/apagarSecao")
	public String apagarSecao(Long id)
	{
		this.sDAO.apagar(id);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/alterarSecaoFormulario")
	public String alterarSecaoFormulario(Long id, Model model)
	{
		Secao secao = this.sDAO.recuperar(id);
		model.addAttribute("secao", secao);
		return "secao/alterar_secao_formulario";
	}
	
	@RequestMapping("/alterarSecao")
	public String alterarSecao(Secao secao)
	{
		Secao s = sDAO.recuperar(secao.getId());
		secao.setNoticias(s.getNoticias());
		this.sDAO.alterar(secao);
		return "redirect:listarSecao";
	}
	
}
