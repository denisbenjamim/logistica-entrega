package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EnderecoPedidoTest {

    @Test
    void testCriarEnderecoPedidoComDadosValidos() {
        String numero = "123";
        String complemento = "Apto 4";
        String cep = "12345-678";

        EnderecoPedido enderecoPedido = new EnderecoPedido(numero, complemento, cep);

        assertEquals(numero, enderecoPedido.getNumero());
        assertEquals(complemento, enderecoPedido.getComplemento());
        assertEquals(cep, enderecoPedido.getCep());
    }

}
