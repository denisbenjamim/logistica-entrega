package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {

    @Test
    public void testGetCodigoProduto() {
        Produto produto = new Produto(123, 10);
        assertEquals(123, produto.getCodigoProduto());
    }

    @Test
    public void testGetQuantidade() {
        Produto produto = new Produto(456, 20);
        assertEquals(20, produto.getQuantidade());
    }
}
