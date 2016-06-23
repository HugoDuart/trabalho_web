package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufc.classes.Classificado;
import br.ufc.classes.Noticia;

public class ClassificadoDAO 
{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classificado)
	{
		manager.persist(classificado);
	}
	
	public void alterar(Classificado classificado)
	{
		manager.merge(classificado);
	}
	
	public Classificado recuperar(Long id)
	{
		return manager.find(Classificado.class,id);
	}
	
	public Classificado recuperar(String titulo) {
		String hql = "select c from CLASSIFICADO as c "
				+ " where c.titulo = :param_login";
		
		Query query = manager.createQuery(hql);
		List <Classificado>classificados = query.setParameter("param_login", titulo).getResultList();
		if(classificados.size() != 0)
		{
			return classificados.get(0);
		}
		return null;
	}
	
	public void apagar(Long id)
	{
		Classificado c = this.recuperar(id);
		if(c != null)
			manager.remove(c);
	}
	
	public List<Classificado> listar()
	{
		String hql = "select c from CLASSIFICADO as c";
		return manager.createQuery(hql, Classificado.class).getResultList();
	}
	
	public List<Classificado> listar_recentes()
	{
		String hql = "select c from CLASSIFICADO as c order by id desc";
		return manager.createQuery(hql, Classificado.class).getResultList();
	}
}
