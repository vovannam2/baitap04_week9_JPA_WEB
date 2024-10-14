package vn.iostar.config;

import jakarta.persistence.*;

@PersistenceContext
public class JPAConfig {
	public static EntityManager getEntityManager() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate-sql");
		return factory.createEntityManager();

	}
}
