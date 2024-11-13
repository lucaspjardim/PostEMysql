package org.br.lucaspjardim.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.br.lucaspjardim.model.Cliente;
import org.br.lucaspjardim.util.JPAUtil;
import org.br.lucaspjardim.model.Venda;



/**
 * Author: Lucas Jardim
 */
public class VendaDAO {

    public void salvar(Venda venda) {
        salvarNoBanco("PostgresUnit", venda);
        salvarNoBanco("MySQLUnit", venda);
    }

    private void salvarNoBanco(String unidadePersistencia, Venda venda) {
        EntityManager em = JPAUtil.getEntityManager(unidadePersistencia);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(venda); // Use merge instead of persist
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
