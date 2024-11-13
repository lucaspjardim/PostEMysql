package org.br.lucaspjardim.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.br.lucaspjardim.util.JPAUtil;
import org.br.lucaspjardim.model.Cliente;




/**
 * Author: Lucas Jardim
 */
public class ClienteDAO {

    public void salvar(Cliente cliente) {
        salvarNoBanco("PostgresUnit", cliente);
        salvarNoBanco("MySQLUnit", cliente);
    }

    private void salvarNoBanco(String persistenceUnit, Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager(persistenceUnit);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(cliente); // Use merge instead of persist
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
