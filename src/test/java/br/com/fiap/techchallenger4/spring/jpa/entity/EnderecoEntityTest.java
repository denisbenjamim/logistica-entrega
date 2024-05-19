package br.com.fiap.techchallenger4.spring.jpa.entity;

import org.junit.jupiter.api.Test;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.EstadoBrasil;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.TipoEnderecoEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoEntityTest {

    @Test
    void testGettersAndSetters() {
        EnderecoEntity endereco = new EnderecoEntity();

        endereco.setCep("12345-678");
        endereco.setLongitude(45.678);
        endereco.setLatitude(67.890);
        endereco.setEstado(EstadoBrasil.SP);
        endereco.setNomeCidade("São Paulo");
        endereco.setNomeBairro("Centro");
        endereco.setNomeEndreco("Rua Exemplo");
        endereco.setTipoEndereco(TipoEnderecoEnum.RESIDENCIAL);

        assertEquals("12345-678", endereco.getCep());
        assertEquals(45.678, endereco.getLongitude());
        assertEquals(67.890, endereco.getLatitude());
        assertEquals(EstadoBrasil.SP, endereco.getEstado());
        assertEquals("São Paulo", endereco.getNomeCidade());
        assertEquals("Centro", endereco.getNomeBairro());
        assertEquals("Rua Exemplo", endereco.getNomeEndreco());
        assertEquals(TipoEnderecoEnum.RESIDENCIAL, endereco.getTipoEndereco());
    }
}