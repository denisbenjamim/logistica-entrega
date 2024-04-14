package br.com.fiap.techchallenger4.spring.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.CEP;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.EstadoBrasil;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.TipoEnderecoEnum;
import br.com.fiap.techchallenger4.spring.infra.CustomTipoLogradouradoDeserializer;
import lombok.Data;

@Data
public class CepAwesomeApi implements CEP{

	private String cep;
	
	@JsonProperty("lng")
    private double longitude;
	
	@JsonProperty("lat")
    private double latitude;
	
	@JsonProperty("state")
    private EstadoBrasil estado;
	
	@JsonProperty("city")
    private String nomeCidade;
	
	@JsonProperty("district")
    private String nomeBairro;
	
	@JsonProperty("address_name")
    private String nomeEndreco;
	
	@JsonDeserialize(using = CustomTipoLogradouradoDeserializer.class)
	@JsonProperty("address_type")
    private TipoEnderecoEnum tipoEndereco;
	
	

}
