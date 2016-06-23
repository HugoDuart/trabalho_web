package br.ufc.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="CLASSIFICADO")
public class Classificado 
{
	@Id
	@Column(name="CLASSIFICADO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="COMPRADOR", nullable=true)
	private Long compradorId;
	
	@Column(name="TITULO",nullable=false)
	private String titulo;
	
	@Column(name="TEXTO",nullable=false)
	private String texto;
	
	@Column(name="PRECO",nullable=false)
	private Double preco;
	
	@Column(name="TELEFONE",nullable=false)
	private String telefone;
	
	@Column(name="MELHOR_OFERTA")
	private Double melhor_oferta;
	
	@Column(name="DATA_OFERTA",nullable=false)
	private Date data_oferta;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID",
				referencedColumnName="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name="USUARIO_ID",insertable=false,updatable=false, nullable=false)
	private Long usuarioId;
	
	
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getMelhor_oferta() {
		return melhor_oferta;
	}

	public void setMelhor_oferta(Double melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}

	public Date getData_oferta() {
		return data_oferta;
	}

	public void setData_oferta(Date data_oferta) {
		this.data_oferta = data_oferta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario autor) {
		this.usuario = autor;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getCompradorId() {
		return compradorId;
	}

	public void setCompradorId(Long compradorId) {
		this.compradorId = compradorId;
	}
	
}
