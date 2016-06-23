package br.ufc.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ufc.classes.Usuario;

@Entity(name="COMENTARIO")
public class Comentario 
{
	@Id
	@Column(name="COMENTARIO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="TEXTO",nullable=false)
	private String texto;

	@ManyToOne(optional=false)
	@JoinColumn(name="USUARIO_ID",
				referencedColumnName="USUARIO_ID")
	private Usuario usuario;
	
	@Column(name="USUARIO_ID",insertable=false,updatable=false,nullable=false)
	private Long usuarioId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="NOTICIA_ID", referencedColumnName="NOTICIA_ID")
	private Noticia noticia;
	
	@Column(name="NOTICIA_ID", insertable=false,updatable=false,nullable=false)
	private Long noticiaId;
	
	/*GETs and SETs */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}
	
}
