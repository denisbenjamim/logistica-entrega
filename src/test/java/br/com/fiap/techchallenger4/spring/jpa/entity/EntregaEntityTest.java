package br.com.fiap.techchallenger4.spring.jpa.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


public class EntregaEntityTest {

    @Test
    void testGettersAndSetters() {
        EntregaEntity entrega = new EntregaEntity();

        entrega.setCodigoEntrega(1L);
        EntregadorEntity entregador = new EntregadorEntity();
        entrega.setEntregador(entregador);
        PedidoEntity pedido = new PedidoEntity();
        entrega.setPedido(pedido);
        LocalDateTime dataEntrega = LocalDateTime.now();
        entrega.setDataEntrega(dataEntrega);

        assertEquals(1L, entrega.getCodigoEntrega());
        assertEquals(entregador, entrega.getEntregador());
        assertEquals(pedido, entrega.getPedido());
        assertEquals(dataEntrega, entrega.getDataEntrega());
    }
}


