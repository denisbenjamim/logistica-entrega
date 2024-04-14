package br.com.fiap.techchallenger4.logisticaentrega.dominio.controller;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EnderecoService;
import br.com.fiap.techchallenger4.spring.service.ConsumerCEP;

public class EnderecoController {
    private final EnderecoService enderecoService;
    private final ConsumerCEP consumerCEP;

    public EnderecoController(EnderecoService enderecoService, ConsumerCEP consumerCEP) {
        this.enderecoService = enderecoService;
        this.consumerCEP = consumerCEP;
    }
    
    public Endereco getEnderecoPeloCep(final String cep) throws BusinessException{
        Endereco enderecoPeloCep = enderecoService.getEnderecoPeloCep(cep);
        if(enderecoPeloCep == null){
        	enderecoPeloCep = consumerCEP.getPorCep(cep).toEndereco();
        	enderecoPeloCep = enderecoService.salvarEndereco(enderecoPeloCep);
        }
        return enderecoPeloCep;
    }
}
