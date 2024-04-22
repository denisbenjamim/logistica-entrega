package br.com.fiap.techchallenger4.logisticaentrega.dominio.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EnderecoService;
import br.com.fiap.techchallenger4.spring.consumer.CepConsumerFeignClient;

public class EnderecoController {
    private final EnderecoService enderecoService;
    private final CepConsumerFeignClient cepConsumer;

    public EnderecoController(EnderecoService enderecoService, CepConsumerFeignClient cepConsumer) {
        this.enderecoService = enderecoService;
        this.cepConsumer = cepConsumer;
    }
    
    public Endereco getEnderecoPeloCep(final String cep) throws BusinessException{
        Endereco enderecoPeloCep = enderecoService.getEnderecoPeloCep(cep);
        if(enderecoPeloCep == null){
        	enderecoPeloCep = cepConsumer.getPorCep(cep).toEndereco();
        	enderecoPeloCep = enderecoService.salvarEndereco(enderecoPeloCep);
        }
        return enderecoPeloCep;
    }
}
