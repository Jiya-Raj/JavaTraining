package tms.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManFactory {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ymali_pu");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}
}
