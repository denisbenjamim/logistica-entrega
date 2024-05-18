package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.fiap.estrutura.exception.BusinessException;

class EntregadorTest {

    @Test
    void testCriarEntregaComDadosValidos() throws BusinessException {
        long codigoEntrega = 1L;
        String nome = "João";
        String cpf = "12345678900";
        String numeroTelefone = "987654321";

        Entregador entregador = new Entregador(codigoEntrega, nome, cpf, numeroTelefone);

        assertEquals(codigoEntrega, entregador.getIdEntregador());
        assertEquals(nome, entregador.getNome());
        assertEquals(cpf, entregador.getCpf());
        assertEquals(numeroTelefone, entregador.getNumeroTelefone());
    }

    @Test
    void testCriarEntregaComCodigoMenorOuIgualAZero() {
        long codigoEntrega = 0L;
        String nome = "João";
        String cpf = "12345678900";
        String numeroTelefone = "987654321";

        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entregador(codigoEntrega, nome, cpf, numeroTelefone));
        assertEquals("Codigo do entregador nao pode ser menor ou igual a zero", exception.getMessage());
    }

    @Test
    void testCriarEntregaComNomeNuloOuVazio() {
        long codigoEntrega = 1L;
        String cpf = "12345678900";
        String numeroTelefone = "987654321";

        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entregador(codigoEntrega, null, cpf, numeroTelefone));
        assertEquals("Nome é obrigatório", exception.getMessage());
    }

    @Test
    void testCriarEntregaComCpfNuloOuVazio() {
        long codigoEntrega = 1L;
        String nome = "João";
        String numeroTelefone = "987654321";

        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entregador(codigoEntrega, nome, null, numeroTelefone));
        assertEquals("CPF é obrigatório", exception.getMessage());
    }

    @Test
    void testCriarEntregaComNumeroTelefoneNuloOuVazio() {
        long codigoEntrega = 1L;
        String nome = "João";
        String cpf = "12345678900";

        BusinessException exception = assertThrows(BusinessException.class,
                () -> new Entregador(codigoEntrega, nome, cpf, null));
        assertEquals("Número de telefone é obrigatório", exception.getMessage());
    }
}
