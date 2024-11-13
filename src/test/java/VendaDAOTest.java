
import org.br.lucaspjardim.dao.VendaDAO;
import org.br.lucaspjardim.model.Venda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Author: Lucas Jardim
 */
public class VendaDAOTest {

    private VendaDAO vendaDAO = new VendaDAO();

    @Test
    public void testSalvar() {
        Venda venda = new Venda("Venda de Teste", 100.50);
        assertDoesNotThrow(() -> vendaDAO.salvar(venda));
    }
}
