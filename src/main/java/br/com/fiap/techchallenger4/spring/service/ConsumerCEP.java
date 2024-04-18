package br.com.fiap.techchallenger4.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.CEP;
import br.com.fiap.techchallenger4.spring.consumer.CepAwesomeApi;
import br.com.fiap.techchallenger4.spring.consumer.EndpointConsumer;

@Service
public class ConsumerCEP {
    
    public CEP getPorCep(final String cep) throws BusinessException{
        final RestTemplate restTemplate = new RestTemplate();

        EndpointConsumer end1 = getEnpointAwesomeApi(cep);
        
        try {
            return restTemplate.getForObject(end1.getUrlEndpoint(), CepAwesomeApi.class);
        } catch (HttpClientErrorException e) {           
            throw new BusinessException(e.getMessage());
        }
    }

    private EndpointConsumer getEnpointAwesomeApi(String cep){
        return new EndpointConsumer("https://cep.awesomeapi.com.br/json/"+cep);
    }

}
