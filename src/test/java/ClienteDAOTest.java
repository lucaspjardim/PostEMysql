import org.br.lucaspjardim.dao.ClienteDAO;
import org.br.lucaspjardim.model.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Author: Lucas Jardim
 */
public class ClienteDAOTest {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @Test
    public void testSalvar() {
        Cliente cliente = new Cliente("Teste Cliente", "teste.cliente@example.com");
        assertDoesNotThrow(() -> clienteDAO.salvar(cliente));
    }
}
