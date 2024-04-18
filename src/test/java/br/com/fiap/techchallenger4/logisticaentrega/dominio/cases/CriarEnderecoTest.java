package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;

class CriarEnderecoTest {
	
	@Mock
	private EnderecoRepository repository;
	
	private AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void naoDeveCriarEnderecoCasoNull() {
		final BusinessException casoNull = assertThrowsExactly(BusinessException.class, () ->{
			new CriarEndereco(repository).criar(null);
		});
		
		assertEquals("Endereço é obrigatório na criaçao do mesmo", casoNull.getMessage());
	}

}
