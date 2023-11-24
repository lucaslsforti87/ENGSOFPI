package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Carros;
import util.JPAUtil;

public class CarrosDao {
	
	public static void salvar(Carros c) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Carros c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Carros c) {
		
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		c = em.find(Carros.class, c.getId());
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Carros> listarComFiltro(Carros filtroCarro) {
        EntityManager em = JPAUtil.criarEntityManager();

        // Construa a consulta JPQL dinamicamente com base nos campos não nulos do filtroCarro
        StringBuilder jpqlBuilder = new StringBuilder("SELECT c FROM Carro c WHERE 1=1");

        if (filtroCarro.getId() != 0) {
            jpqlBuilder.append(" AND c.id = :id");
        }
        if (filtroCarro.getMarca() != null && !filtroCarro.getMarca().isEmpty()) {
            jpqlBuilder.append(" AND c.marca LIKE :marca");
        }
        if (filtroCarro.getModelo() != null && !filtroCarro.getModelo().isEmpty()) {
            jpqlBuilder.append(" AND c.modelo LIKE :modelo");
        }
        if (filtroCarro.getAnoFabricacao() != 0) {
            jpqlBuilder.append(" AND c.anoFabricacao = :anoFabricacao");
        }
        if (filtroCarro.getAnoModelo() != 0) {
            jpqlBuilder.append(" AND c.anoModelo = :anoModelo");
        }
        if (filtroCarro.getValorCarro() != null) {
            jpqlBuilder.append(" AND c.valor = :valor");
        }
        if (filtroCarro.getDescricao_Carro() != null && !filtroCarro.getDescricao_Carro().isEmpty()) {
            jpqlBuilder.append(" AND c.descricao LIKE :descricao");
        }

        // Crie a consulta
        Query q = em.createQuery(jpqlBuilder.toString());

        // Defina os parâmetros da consulta com base nos campos não nulos do filtroCarro
        if (filtroCarro.getId() != 0) {
            q.setParameter("id", filtroCarro.getId());
        }
        if (filtroCarro.getMarca() != null && !filtroCarro.getMarca().isEmpty()) {
            q.setParameter("marca", "%" + filtroCarro.getMarca() + "%");
        }
        if (filtroCarro.getModelo() != null && !filtroCarro.getModelo().isEmpty()) {
            q.setParameter("modelo", "%" + filtroCarro.getModelo() + "%");
        }
        if (filtroCarro.getAnoFabricacao() != 0) {
            q.setParameter("anoFabricacao", filtroCarro.getAnoFabricacao());
        }
        if (filtroCarro.getAnoModelo() != 0) {
            q.setParameter("anoModelo", filtroCarro.getAnoModelo());
        }
        if (filtroCarro.getValorCarro() != null) {
            q.setParameter("valor", filtroCarro.getValorCarro());
        }
        if (filtroCarro.getDescricao_Carro() != null && !filtroCarro.getDescricao_Carro().isEmpty()) {
            q.setParameter("descricao", "%" + filtroCarro.getDescricao_Carro() + "%");
        }

        // Execute a consulta e obtenha os resultados
        List<Carros> listaCarros = q.getResultList();

        // Feche o EntityManager
        em.close();

        // Retorne a lista de carros filtrada
        return listaCarros;
    }
}