package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ufc.classes.Secao;

public class SecaoDAO 
{
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Secao secao)
	{
		manager.persist(secao);
	}
	
	public void alterar(Secao secao)
	{
		manager.merge(secao);
	}
	
	public Secao recuperar(Long id)
	{
		return manager.find(Secao.class,id);
	}
	
	public Secao recuperar(String titulo)
	{
		String hql = "select s from SECAO as s "
				+ " where s.titulo = :param_login";
		
		Query query = manager.createQuery(hql);
		Secao s = (Secao) query.setParameter("param_login", titulo).getSingleResult();
		if(s != null)
			return s;
		return null;
	}
	
	public void apagar(Long id)
	{
		Secao s = this.recuperar(id);
		if(s != null)
			manager.remove(s);
	}
	
	public List<Secao> listar()
	{
		String hql = "select s from SECAO as s";
		return manager.createQuery(hql, Secao.class).getResultList();
	}
}
