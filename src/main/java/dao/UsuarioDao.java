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
	
	public static List<Usuario> listarComFiltro(Usuario filtroUsuario) {
        EntityManager em = JPAUtil.criarEntityManager();

        try {
            // Construa a consulta JPQL dinamicamente com base nos campos não nulos do filtroUsuario
            StringBuilder jpqlBuilder = new StringBuilder("SELECT u FROM Usuario u WHERE 1=1");

            if (filtroUsuario.getId() != 0) {
                jpqlBuilder.append(" AND u.id = :id");
            }
            if (filtroUsuario.getLogin() != null && !filtroUsuario.getLogin().isEmpty()) {
                jpqlBuilder.append(" AND u.login LIKE :login");
            }
            if (filtroUsuario.getSenha() != null && !filtroUsuario.getSenha().isEmpty()) {
                jpqlBuilder.append(" AND u.senha LIKE :senha");
            }
            if (filtroUsuario.getNomeUsuario() != null && !filtroUsuario.getNomeUsuario().isEmpty()) {
                jpqlBuilder.append(" AND u.nome LIKE :nome");
            }
            
            if (filtroUsuario.getDataNascimento() != null) {
                jpqlBuilder.append(" AND u.dataNascimento = :dataNascimento");
            }
            if (filtroUsuario.getDataCadastro() != null) {
                jpqlBuilder.append(" AND u.dataCadastro = :dataCadastro");
            }

            // Crie a consulta
            Query q = em.createQuery(jpqlBuilder.toString());

            // Defina os parâmetros da consulta com base nos campos não nulos do filtroUsuario
            if (filtroUsuario.getId() != 0) {
                q.setParameter("id", filtroUsuario.getId());
            }
            if (filtroUsuario.getLogin() != null && !filtroUsuario.getLogin().isEmpty()) {
                q.setParameter("login", "%" + filtroUsuario.getLogin() + "%");
            }
            if (filtroUsuario.getSenha() != null && !filtroUsuario.getSenha().isEmpty()) {
                q.setParameter("senha", "%" + filtroUsuario.getSenha() + "%");
            }
            if (filtroUsuario.getNomeUsuario() != null && !filtroUsuario.getNomeUsuario().isEmpty()) {
                q.setParameter("nome", "%" + filtroUsuario.getNomeUsuario() + "%");
            }
           
            if (filtroUsuario.getDataNascimento() != null) {
                q.setParameter("dataNascimento", filtroUsuario.getDataNascimento());
            }
            if (filtroUsuario.getDataCadastro() != null) {
                q.setParameter("dataCadastro", filtroUsuario.getDataCadastro());
            }

            // Execute a consulta e obtenha os resultados
            List<Usuario> listaUsuarios = q.getResultList();

            return listaUsuarios;
        } finally {
            // Certifique-se de fechar o EntityManager no bloco finally para liberar recursos
            em.close();
        }
    }
}
