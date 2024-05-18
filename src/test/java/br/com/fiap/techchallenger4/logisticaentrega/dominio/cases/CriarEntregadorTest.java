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
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;

class CriarEntregadorTest {

    private EntregadorRepository mockRepository;
    private CriarEntregador criarEntregador;

    @BeforeEach
    void setUp() {
        mockRepository = mock(EntregadorRepository.class);
        criarEntregador = new CriarEntregador(mockRepository);
    }

    @Test
    void testCriarComEntregadorValido() throws BusinessException {
        Entregador entregador = new Entregador(); 

       when(mockRepository.criar(entregador)).thenReturn(entregador);

        Entregador resultado = criarEntregador.criar(entregador);

        verify(mockRepository).criar(entregador);

        assertNotNull(resultado);
    }

    @Test
    void testCriarComEntregadorNulo() {
        BusinessException exception = assertThrows(BusinessException.class, () -> criarEntregador.criar(null));
        assertEquals("Entregador é obrigatório para ser criado", exception.getMessage());
    }
}
