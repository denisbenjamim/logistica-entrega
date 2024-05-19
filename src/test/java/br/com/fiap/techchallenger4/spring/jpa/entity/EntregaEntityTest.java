package br.com.fiap.techchallenger4.spring.jpa.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void testPrePersist() {
        EntregaEntity entregaEntity = new EntregaEntity();
        entregaEntity.gravarDataEntrega();

        assertNotNull(entregaEntity.getDataEntrega());
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dataEntrega = entregaEntity.getDataEntrega();
        assertEquals(now.getYear(), dataEntrega.getYear());
        assertEquals(now.getMonth(), dataEntrega.getMonth());
        assertEquals(now.getDayOfMonth(), dataEntrega.getDayOfMonth());
        assertEquals(now.getHour(), dataEntrega.getHour());
        assertEquals(now.getMinute(), dataEntrega.getMinute());
    }
}


