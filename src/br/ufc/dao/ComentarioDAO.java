package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.classes.Comentario;

public class ComentarioDAO 
{
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Comentario comentario)
	{
		manager.persist(comentario);
	}
	
	public void alterar(Comentario comentario)
	{
		manager.merge(comentario);
	}
	
	public Comentario recuperar(Long id)
	{
		return manager.find(Comentario.class,id);
	}
	
	public void apagar(Long id)
	{
		Comentario c = this.recuperar(id);
		if(c != null)
			manager.remove(c);
	}
	
	public List<Comentario> listar()
	{
		String hql = "select c from COMENTARIO as c";
		return manager.createQuery(hql, Comentario.class).getResultList();
	}
}
