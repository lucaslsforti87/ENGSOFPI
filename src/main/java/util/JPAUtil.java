package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Classe para criar objetos do tipo EntityManager
public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PIVLOCACAO");
	
	//método estático para criar uma instância da fábrica de EntityManager
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
}
