package br.ufc.classes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity(name="PAPEL")
public class Papel 
{
	@Id
	@Column(name="PAPEL_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="PAPEL", nullable=false)
	private String papel;
	
	@ManyToMany(mappedBy="papeis",fetch=FetchType.EAGER)
	private List<Usuario> usuarios;
	
	/*GETs and SETs*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
