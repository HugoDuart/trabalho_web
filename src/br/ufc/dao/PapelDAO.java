package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import br.ufc.classes.Papel;
import br.ufc.classes.Secao;
import br.ufc.classes.Usuario;

@Repository
public class PapelDAO {

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@PersistenceContext
	private EntityManager manager;
	
	public Papel recuperar(Long id) {
		return manager.find(Papel.class, id);
	}
	
	public Papel recuperar(String papel) {
		String hql = "select p from PAPEL as p "
				+ " where p.papel = :param_login";
		
		Query query = manager.createQuery(hql);
		List <Papel>papeis = query.setParameter("param_login", papel).getResultList();
		if(papeis.size() != 0)
		{
			return papeis.get(0);
		}
		return null;
	}
	
	public void alterar(Papel papel) {
		manager.merge(papel);
		
	}
	
	public boolean buscarPapel(Long usuario_id, String papel)
	{
		Usuario usuario = uDAO.recuperar(usuario_id);
		List<Papel>papeis=usuario.getPapeis();
		for(Papel p : papeis)
			if(p.getPapel().equals(papel))
				return true;
		return false;
	}
	
	public List<Papel> listar()
	{
		String hql = "select p from PAPEL as p";
		return manager.createQuery(hql, Papel.class).getResultList();
	} 
	
}
