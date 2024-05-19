package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.fiap.estrutura.exception.BusinessException;

public class EntregadorTest {

    @Test
    public void testConstructorWithValidParameters() throws BusinessException {
        Long id = 1L;
        String nome = "John Doe";
        String cpf = "123.456.789-00";
        String numeroTelefone = "1234567890";

        Entregador entregador = new Entregador(id, nome, cpf, numeroTelefone);

        assertEquals(id, entregador.getIdEntregador());
        assertEquals(nome, entregador.getNome());
        assertEquals(cpf, entregador.getCpf());
        assertEquals(numeroTelefone, entregador.getNumeroTelefone());
    }

    @Test
    public void testConstructorWithBlankNome() {
        Long id = 1L;
        String cpf = "123.456.789-00";
        String numeroTelefone = "1234567890";

        Exception exception = assertThrows(BusinessException.class, () -> {
            new Entregador(id, " ", cpf, numeroTelefone);
        });

        assertEquals("Nome é obrigatório", exception.getMessage());
    }

    @Test
    public void testConstructorWithBlankCpf() {
        Long id = 1L;
        String nome = "John Doe";
        String numeroTelefone = "1234567890";

        Exception exception = assertThrows(BusinessException.class, () -> {
            new Entregador(id, nome, " ", numeroTelefone);
        });

        assertEquals("CPF é obrigatório", exception.getMessage());
    }

    @Test
    public void testConstructorWithBlankNumeroTelefone() {
        Long id = 1L;
        String nome = "John Doe";
        String cpf = "123.456.789-00";

        Exception exception = assertThrows(BusinessException.class, () -> {
            new Entregador(id, nome, cpf, " ");
        });

        assertEquals("Número de telefone é obrigatório", exception.getMessage());
    }
}
