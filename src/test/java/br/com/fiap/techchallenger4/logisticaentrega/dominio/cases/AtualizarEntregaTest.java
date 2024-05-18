package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

class AtualizarEntregaTest {

    private EntregaRepository mockRepository;
    private AtualizarEntrega atualizarEntrega;

    @BeforeEach
    void setUp() {
        mockRepository = mock(EntregaRepository.class);
        atualizarEntrega = new AtualizarEntrega(mockRepository);
    }

    @Test
    void testAtualizarComIdsValidos() throws BusinessException {
        Long idEntrega = 1L;
        Long idEntregador = 10L;
        Entrega entregaMock = new Entrega(); 

        when(mockRepository.atualizar(idEntrega, idEntregador)).thenReturn(entregaMock);

        Entrega resultado = atualizarEntrega.atualizar(idEntrega, idEntregador);

        verify(mockRepository).atualizar(idEntrega, idEntregador);

        assertNotNull(resultado);
    }

    @Test
    void testAtualizarComIdEntregaNulo() {
        BusinessException exception = assertThrows(BusinessException.class, () -> atualizarEntrega.atualizar(null, 10L));
        assertEquals("Id da entrega deve ser válido", exception.getMessage());
    }

    @Test
    void testAtualizarComIdEntregadorNulo() {
        BusinessException exception = assertThrows(BusinessException.class, () -> atualizarEntrega.atualizar(1L, null));
        assertEquals("Id de entregador deve ser válido", exception.getMessage());
    }
}