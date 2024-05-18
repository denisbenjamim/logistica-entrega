package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

class BuscarEntregaTest {

    private EntregaRepository mockRepository;
    private BuscarEntrega buscarEntrega;

    @BeforeEach
    void setUp() {
        mockRepository = mock(EntregaRepository.class);
        buscarEntrega = new BuscarEntrega(mockRepository);
    }

    @Test
    void testBuscarPorIdComCodigoValido() throws BusinessException {
        Long codigoEntrega = 1L;
        Entrega entregaMock = new Entrega(); 

        when(mockRepository.buscarPorId(codigoEntrega)).thenReturn(entregaMock);

        Entrega resultado = buscarEntrega.buscarPorId(codigoEntrega);

        verify(mockRepository).buscarPorId(codigoEntrega);

        assertNotNull(resultado);
    }

    @Test
    void testBuscarPorIdComCodigoNulo() {
        BusinessException exception = assertThrows(BusinessException.class, () -> buscarEntrega.buscarPorId(null));
        assertEquals("Insira um código de entrega verdadeiro", exception.getMessage());
    }

    @Test
    void testBuscarEntregaSemData() throws BusinessException {
        when(mockRepository.buscarEntregaSemData()).thenReturn(Collections.emptyList());

        List<Entrega> resultado = buscarEntrega.buscarEntregaSemData();

        verify(mockRepository).buscarEntregaSemData();

        assertNotNull(resultado);
    }
}