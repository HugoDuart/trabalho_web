package br.ufc.classes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="NOTICIA")
public class Noticia 
{
	@Id
	@Column(name="NOTICIA_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="TITULO",nullable=false)
	private String titulo;
	
	@Column(name="SUBTITULO",nullable=false)
	private String subtitulo;
	
	@Lob
	@Column(name="TEXTO",nullable=false)
	private String texto;
	
	@Column(name="DATA_NOTICIA",nullable=false)
	private Date data_noticia;
	
	@ManyToOne( optional=false)
	@JoinColumn(name="USUARIO_ID",
				referencedColumnName="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name="USUARIO_ID",insertable=false,updatable=false, nullable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="SECAO_ID",
				referencedColumnName="SECAO_ID")
	private Secao secao;
	
	@Column(name="SECAO_ID",insertable=false,updatable=false,nullable=false)
	private Long secaoId;
	
	@OneToMany(mappedBy="noticia",
			   targetEntity=Comentario.class,
			   fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comentario> comentarios;

	
	/* GETs and SETs */
	
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

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData_noticia() {
		return data_noticia;
	}

	public void setData_noticia(Date data_noticia) {
		this.data_noticia = data_noticia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Long getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(Long secaoId) {
		this.secaoId = secaoId;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
