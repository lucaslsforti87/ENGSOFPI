package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Carro;
import util.JPAUtil;

public class CarroDao {
	
	public static void salvar(Carro i) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Carro i) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(i);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Carro i) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		i = em.find(Carro.class, i.getId());
		em.remove(i);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static List<Carro> listarTodos() {
		
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select i from Carro i");
		@SuppressWarnings("unchecked")
		List<Carro> list = q.getResultList();
		em.close();
		return list;
	}
	
	
	public static Carro listarPorId(Integer id) {
	
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Carro i = em.find(Carro.class, id);
		em.close();
		return i;
	}	
}
