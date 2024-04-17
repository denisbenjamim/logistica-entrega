package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;

class EnderecoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void deveInvalidarCepCasoQuantidadeDigitosAcimaOuBaixoEsperado() {
		final BusinessException cepComLetra = assertThrows(BusinessException.class, () -> {
			new Endereco("1111100A", 0, 0, null, null, null, null, null);
		});
		assertEquals("CEP deve ter 8 digitos", cepComLetra.getMessage());
		
		final BusinessException cepComMenosOitoDigitos = assertThrows(BusinessException.class, () -> {
			new Endereco("1111100", 0, 0, null, null, null, null, null);
		});
		assertEquals("CEP deve ter 8 digitos", cepComMenosOitoDigitos.getMessage());
		
		final BusinessException cepComMaisOitoDigitos = assertThrows(BusinessException.class, () -> {
			new Endereco("111110000", 0, 0, null, null, null, null, null);
		});
		assertEquals("CEP deve ter 8 digitos", cepComMaisOitoDigitos.getMessage());
	}
	
	@Test
	void deveInvalidarCepCasoNullOuVazio() {
		final BusinessException cepNull = assertThrows(BusinessException.class, () -> {
			new Endereco(null, 0, 0, null, null, null, null, null);
		});
		assertEquals("CEP é obrigatório", cepNull.getMessage());
		
		final BusinessException cepStringVazia = assertThrows(BusinessException.class, () -> {
			new Endereco("", 0, 0, null, null, null, null, null);
		});
		assertEquals("CEP é obrigatório", cepStringVazia.getMessage());
		
		final BusinessException cepStringEspaco = assertThrows(BusinessException.class, () -> {
			new Endereco("       ", 0, 0, null, null, null, null, null);
		});
		assertEquals("CEP é obrigatório", cepStringEspaco.getMessage());
	}
	
	@Test
	void deveInvalidarLongitudeCasoZero() {
		final BusinessException exception = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", 0, 0, null, null, null, null, null);
		});
		assertEquals("Longitude é obrigatório", exception.getMessage());
	}
	
	@Test
	void deveInvalidarLatitudeCasoZero() {
		final BusinessException exception = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 0, null, null, null, null, null);
		});
		assertEquals("Latitude é obrigatória", exception.getMessage());
	}
	
	@Test
	void deveInvalidarEstadoCasoNull() {
		final BusinessException exception = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, null, null, null, null, null);
		});
		assertEquals("Estado é obrigatório", exception.getMessage());
	}
	
	@Test
	void deveInvalidarNomeCidadeCasoNullOuVazio() {
		final BusinessException nomeCidadeNull = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, null, null, null, null);
		});
		assertEquals("Nome da cidade é obrigatório", nomeCidadeNull.getMessage());
		
		final BusinessException nomeCidadeVazio = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "  ", null, null, null);
		});
		assertEquals("Nome da cidade é obrigatório", nomeCidadeVazio.getMessage());
	}
	
	@Test
	void deveInvalidarNomeBairroCasoNullOuVazio() {
		final BusinessException nomeBairroNull = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "bairro", null, null, null);
		});
		assertEquals("Nome do bairro é obrigatório", nomeBairroNull.getMessage());
		
		final BusinessException nomeBairroVazio = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "bairro", " ", null, null);
		});
		assertEquals("Nome do bairro é obrigatório", nomeBairroVazio.getMessage());
	}
	
	@Test
	void deveInvalidarNomeEnderecoCasoNullOuVazio() {
		final BusinessException nomeEnderecoNull = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "bairro", "cidade", null, null);
		});
		assertEquals("Nome do endereço é obrigatório", nomeEnderecoNull.getMessage());
		
		final BusinessException nomeEnderecoVazio = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "bairro", "cidade", "   ", null);
		});
		assertEquals("Nome do endereço é obrigatório", nomeEnderecoVazio.getMessage());
	}
	
	@Test
	void deveInvalidarTipoEnderecoCasoNull() {
		final BusinessException exception = assertThrows(BusinessException.class, () -> {
			new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "bairro", "cidade", "endereco", null);
		});
		assertEquals("Tipo do endereço é obrigatório", exception.getMessage());
	}

	@Test
	void deveCriarEnderecoPosValidar() throws BusinessException {
		final Endereco endereco = new Endereco("11111111", -15.153, 46.345, EstadoBrasil.AC, "bairro", "cidade", "endereco", TipoEnderecoEnum.ACAMPAMENTO);
		assertNotNull(endereco);
	}
}
