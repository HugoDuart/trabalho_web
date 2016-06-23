package br.ufc.classes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name="USUARIO")
public class Usuario 
{
	@Id
	@Column(name="USUARIO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="{usuario.nome.vazio}")
	@Size(min=5, message="{usuario.nome.min}")
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="LOGIN", nullable=false)
	private String login;
	
	@Column(name="SENHA", nullable=false)
	private String senha;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Comentario.class,
			   fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Comentario> comentarios;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Classificado.class,
			   fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Classificado> classificados;
	
	@OneToMany(mappedBy="usuario",
			   targetEntity=Noticia.class,
			   fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Noticia> noticias;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USUARIO_PAPEL",
		joinColumns=@JoinColumn(name="USUARIO_ID",
					   		    referencedColumnName="USUARIO_ID"),
	    inverseJoinColumns=@JoinColumn(name="PAPEL_ID",
					   				   referencedColumnName="PAPEL_ID")
			   )
	private List<Papel> papeis;	
	
	//private String papel;
	
	/*GETs and SETs */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario))
			return false;
		
		Usuario ref = (Usuario) obj;
		if(ref.getId() == this.id)
			return true;
		return false;
	}

	/*public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}*/
	
}
