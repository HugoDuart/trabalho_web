package br.ufc.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="SECAO")
public class Secao 
{
	@Id
	@Column(name="SECAO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="TITULO",nullable=false)
	private String titulo;
	
	@Column(name="DESCRICAO",nullable=false)
	private String descricao;
	
	@OneToMany(mappedBy="secao",
			   targetEntity=Noticia.class,
			   fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Noticia> noticias;
	
	
	/*  GETs and SETs  */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
}
