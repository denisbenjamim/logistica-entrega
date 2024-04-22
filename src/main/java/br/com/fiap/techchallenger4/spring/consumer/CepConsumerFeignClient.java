package br.com.fiap.techchallenger4.spring.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.CEP;

@FeignClient(name = "buscarCepExterno", url="https://cep.awesomeapi.com.br/json")
public interface CepConsumerFeignClient {
    
    @GetMapping("/{cep}")
    CEP getPorCep(@PathVariable final String cep);

}
