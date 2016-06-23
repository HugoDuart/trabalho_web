package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufc.classes.Noticia;


public class NoticiaDAO 
{
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Noticia noticia)
	{
		manager.persist(noticia);
	}
	
	public void alterar(Noticia noticia)
	{
		manager.merge(noticia);
	}
	
	public Noticia recuperar(Long id)
	{
		return manager.find(Noticia.class,id);
	}
	
	public Noticia recuperar(String titulo) {
		String hql = "select n from NOTICIA as n "
				+ " where n.titulo = :param_login";
		
		Query query = manager.createQuery(hql);
		List <Noticia>noticias = query.setParameter("param_login", titulo).getResultList();
		if(noticias.size() != 0)
		{
			return noticias.get(0);
		}
		return null;
	}
	
	public void apagar(Long id)
	{
		Noticia n = this.recuperar(id);
		if(n != null)
			manager.remove(n);
	}
	
	public List<Noticia> listar()
	{
		String hql = "select n from NOTICIA as n";
		return manager.createQuery(hql, Noticia.class).getResultList();
	}
	
	public List<Noticia> listar_recentes()
	{
		String hql = "select n from NOTICIA as n order by id desc";
		return manager.createQuery(hql, Noticia.class).getResultList();
	}
}
