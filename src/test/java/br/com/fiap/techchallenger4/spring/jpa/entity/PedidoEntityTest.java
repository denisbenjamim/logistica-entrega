package br.com.fiap.techchallenger4.spring.jpa.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.EnderecoPedido;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Produto;

public class PedidoEntityTest {

    @Test
    void testAllArgsConstructor() {
        List<PedidoProdutoEmbeddable> produtos = new ArrayList<>();
        produtos.add(new PedidoProdutoEmbeddable(001L, 2L));
        produtos.add(new PedidoProdutoEmbeddable(002L, 3L));

        PedidoEntity pedido = new PedidoEntity(
                                    1L, 
                                    2L, 
                                    LocalDateTime.now(),
                                    "Pendente", 
                                    "12345-678", 
                                    "123", 
                                    "Complemento", 
                                    produtos
                               );

        assertNotNull(pedido);
        assertEquals(1L, pedido.getCodigoPedido());
        assertEquals(2L, pedido.getCodigoCliente());
        assertNotNull(pedido.getDataCriacao());
        assertEquals("Pendente", pedido.getStatusPedido());
        assertEquals("12345-678", pedido.getCep());
        assertEquals("123", pedido.getNumeroEndereco());
        assertEquals("Complemento", pedido.getComplementoEndereco());
        assertEquals(2, pedido.getProdutos().size()); 
    }

    @Test
    void testToEntity() {
        Pedido pedido = new Pedido(
                            1L, 
                            2L, 
                            "Pendente", 
                            LocalDateTime.now(), 
                            null, 
                            new EnderecoPedido("123", "Complemento", "12345-678"), 
                            Arrays.asList(new Produto(1, 2), new Produto(2, 3)) 
                       );

        PedidoEntity pedidoEntity = PedidoEntity.toEntity(pedido);

        assertNotNull(pedidoEntity);
        assertEquals(pedido.getCodigoPedido(), pedidoEntity.getCodigoPedido());
        assertEquals(pedido.getCodigoCliente(), pedidoEntity.getCodigoCliente());
        assertEquals(pedido.getStatusPedido(), pedidoEntity.getStatusPedido());
        assertEquals(pedido.getEndereco().getCep(), pedidoEntity.getCep());
        assertEquals(pedido.getEndereco().getNumero(), pedidoEntity.getNumeroEndereco());
        assertEquals(pedido.getEndereco().getComplemento(), pedidoEntity.getComplementoEndereco());
        assertEquals(pedido.getItens().size(), pedidoEntity.getProdutos().size()); 
    }
}
