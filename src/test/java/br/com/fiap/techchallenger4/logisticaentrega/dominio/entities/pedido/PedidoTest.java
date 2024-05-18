package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class PedidoTest {

    @Test
    void testCriarPedidoComDadosValidos() {
        long codigoPedido = 1L;
        long codigoCliente = 10L;
        String statusPedido = "Em andamento";
        LocalDateTime dataEntrega = LocalDateTime.now();
        LocalDateTime dataEnvio = LocalDateTime.now();
        EnderecoPedido endereco = new EnderecoPedido("123", "Apto 4", "12345-678");
        List<Produto> itens = new ArrayList<>();

        Pedido pedido = new Pedido(codigoPedido, codigoCliente, statusPedido, dataEntrega, dataEnvio, endereco, itens);

        assertEquals(codigoPedido, pedido.getCodigoPedido());
        assertEquals(codigoCliente, pedido.getCodigoCliente());
        assertEquals(statusPedido, pedido.getStatusPedido());
        assertEquals(dataEntrega, pedido.getDataEntrega());
        assertEquals(dataEnvio, pedido.getDataEnvio());
        assertEquals(endereco, pedido.getEndereco());
        assertEquals(itens, pedido.getItens());
    }

}
