package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

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

class BuscarEntregadorTest {

    private EntregadorRepository mockRepository;
    private BuscarEntregador buscarEntregador;

    @BeforeEach
    void setUp() {
        mockRepository = mock(EntregadorRepository.class);
        buscarEntregador = new BuscarEntregador(mockRepository);
    }

    @Test
    void testBuscarPorIdComIdValido() throws BusinessException {
        // Dados de teste
        Long idEntregador = 1L;
        Entregador entregadorMock = new Entregador(); // Simula um entregador

        // Simula o comportamento do repositório
        when(mockRepository.buscarPorId(idEntregador)).thenReturn(entregadorMock);

        // Executa o método buscarPorId
        Entregador resultado = buscarEntregador.buscarPorId(idEntregador);

        // Verifica se o método do repositório foi chamado corretamente
        verify(mockRepository).buscarPorId(idEntregador);

        // Verifica se o resultado não é nulo
        assertNotNull(resultado);
    }

    @Test
    void testBuscarPorIdComIdNulo() {
        // Executa o método buscarPorId com ID nulo
        assertThrows(BusinessException.class, () -> buscarEntregador.buscarPorId(null));
    }
}
