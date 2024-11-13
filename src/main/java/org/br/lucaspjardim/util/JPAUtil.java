package org.br.lucaspjardim.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Author: Lucas Jardim
 */
public class JPAUtil {
    private static final EntityManagerFactory emfPostgres = Persistence.createEntityManagerFactory("PostgresUnit");
    private static final EntityManagerFactory emfMySQL = Persistence.createEntityManagerFactory("MySQLUnit");

    public static EntityManager getEntityManager(String persistenceUnit) {
        if (persistenceUnit.equals("PostgresUnit")) {
            return emfPostgres.createEntityManager();
        } else if (persistenceUnit.equals("MySQLUnit")) {
            return emfMySQL.createEntityManager();
        }
        throw new IllegalArgumentException("Unidade de persistência desconhecida: " + persistenceUnit);
    }

    public static void close() {
        emfPostgres.close();
        emfMySQL.close();
    }
}
