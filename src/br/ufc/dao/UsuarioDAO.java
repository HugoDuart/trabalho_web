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
import br.ufc.classes.Usuario;

@Repository
public class UsuarioDAO
{

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private PapelDAO pDAO;
	
	public void inserir(Usuario usuario) {
		
		manager.persist(usuario);
		
	}

	public void alterar(Usuario usuario) {
		manager.merge(usuario);
		
	}

	public Usuario recuperar(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void atribuirPapel(Long usuario_id, String papel)
	{
		Usuario editor =this.recuperar(usuario_id);
		List<Papel>papeis = editor.getPapeis();
		Papel paper = pDAO.recuperar(papel);
		for(Papel p : papeis)
			if(p.getPapel().equals(papel))
				return;
		papeis.add(paper);
		editor.setPapeis(papeis);
		manager.merge(editor);
	}

	
	public Usuario recuperar(String login) {
		String hql = "select u from USUARIO as u "
				+ " where u.login = :param_login";
		
		Query query = manager.createQuery(hql);
		List <Usuario>usuarios = query.setParameter("param_login", login).getResultList();
		if(usuarios.size() != 0)
		{
			return usuarios.get(0);
		}
		return null;
	}

	public void apagar(Long id) {
		Usuario u = this.recuperar(id);
		if(u != null)
			manager.remove(u);
	}

	public List<Usuario> listar() {
		String hql = "select u from USUARIO as u";
		return manager.createQuery(hql, Usuario.class).getResultList();
	}

}
