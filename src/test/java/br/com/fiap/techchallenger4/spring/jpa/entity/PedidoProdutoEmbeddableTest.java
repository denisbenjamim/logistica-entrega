package br.com.fiap.techchallenger4.spring.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoProdutoEmbeddableTest {

    @Test
    void testAllArgsConstructor() {
        PedidoProdutoEmbeddable produto = new PedidoProdutoEmbeddable(001L, 5L);

        assertNotNull(produto);
        assertEquals(001, produto.getCodigoProduto());
        assertEquals(5, produto.getQuantidade());
    }

    @Test
    void testGetters() {
        PedidoProdutoEmbeddable produto = new PedidoProdutoEmbeddable(002L, 3L);

        assertEquals(02, produto.getCodigoProduto());
        assertEquals(3, produto.getQuantidade());
    }
}
