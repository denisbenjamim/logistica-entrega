package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;

class EntregaTest {

    @Test
    void testCriarEntregaComDadosValidos() throws BusinessException {
        
        long codigoEntrega = 1L;
        Entregador entregador = new Entregador();
        Pedido pedido = new Pedido();

        
        Entrega entrega = new Entrega(codigoEntrega, entregador, pedido);

        
        assertEquals(codigoEntrega, entrega.getCodigoEntrega());
        assertEquals(entregador, entrega.getEntregador());
        assertEquals(pedido, entrega.getPedido());
    }

    @Test
    void testCriarEntregaComCodigoMenorOuIgualAZero() {
        
        long codigoEntrega = 0L;
        Entregador entregador = new Entregador();
        Pedido pedido = new Pedido();

        
        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entrega(codigoEntrega, entregador, pedido));
        assertEquals("Codigo de Entrega nao pode ser menor ou igual a zero", exception.getMessage());
    }

    @Test
    void testCriarEntregaComEntregadorNulo() {
        
        long codigoEntrega = 1L;
        Pedido pedido = new Pedido();

        
        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entrega(codigoEntrega, null, pedido));
        assertEquals("Código entregador é obrigatório", exception.getMessage());
    }

    @Test
    void testCriarEntregaComPedidoNulo() {
        
        long codigoEntrega = 1L;
        Entregador entregador = new Entregador();

        
        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entrega(codigoEntrega, entregador, null));
        assertEquals("Código pedido é obrigatório", exception.getMessage());
    }
}