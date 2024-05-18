package br.com.fiap.techchallenger4.logisticaentrega.infra.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregadorRepositorySpring;

class EntregadorRepositoryImplJPATest {

    private EntregadorRepositorySpring mockRepository;
    private EntregadorRepositoryImplJPA entregadorRepository;

    @BeforeEach
    void setUp() {
        mockRepository = mock(EntregadorRepositorySpring.class);
        entregadorRepository = new EntregadorRepositoryImplJPA(mockRepository);
    }

    @Test
    void testCriarEntregador() throws BusinessException {
        // Dados de teste
        Entregador entregador = new Entregador(); // Crie um objeto Entregador válido

        // Simula o comportamento do repositório
        when(mockRepository.save(any())).thenReturn(EntregadorEntity.toEntity(entregador));

        // Executa o método criar
        Entregador resultado = entregadorRepository.criar(entregador);

        // Verifica se o método do repositório foi chamado corretamente
        verify(mockRepository).save(any());

        // Verifica se o resultado não é nulo
        assertNotNull(resultado);
    }

    @Test
    void testBuscarPorIdComIdExistente() throws BusinessException {
        // Dados de teste
        Long idEntregador = 1L;
        EntregadorEntity entregadorEntity = new EntregadorEntity(); // Simula um entregador no banco de dados

        // Simula o comportamento do repositório
        when(mockRepository.findByIdEntregador(idEntregador)).thenReturn(entregadorEntity);

        // Executa o método buscarPorId
        Entregador resultado = entregadorRepository.buscarPorId(idEntregador);

        // Verifica se o método do repositório foi chamado corretamente
        verify(mockRepository).findByIdEntregador(idEntregador);

        // Verifica se o resultado não é nulo
        assertNotNull(resultado);
    }

    @Test
    void testBuscarPorIdComIdInexistente() throws BusinessException {
        // Dados de teste
        Long idEntregador = 2L; // ID inexistente

        // Simula o comportamento do repositório
        when(mockRepository.findByIdEntregador(idEntregador)).thenReturn(null);

        // Executa o método buscarPorId
        Entregador resultado = entregadorRepository.buscarPorId(idEntregador);

        // Verifica se o método do repositório foi chamado corretamente
        verify(mockRepository).findByIdEntregador(idEntregador);

        // Verifica se o resultado é nulo
        assertNull(resultado);
    }
}
