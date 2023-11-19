package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Usuario;
import util.JPAUtil;

public class UsuarioDao {
	
	public static void salvar(Usuario u) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Usuario u) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Usuario u) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		u = em.find(Usuario.class, u.getId());
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Usuario> listarTodos() {
		
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select u from Usuario u");		
		List<Usuario> list = q.getResultList();
		em.close();
		return list;
	}	
}