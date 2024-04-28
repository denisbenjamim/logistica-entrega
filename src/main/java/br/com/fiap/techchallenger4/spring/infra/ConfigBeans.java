package br.com.fiap.techchallenger4.spring.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EnderecoController;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EnderecoService;
import br.com.fiap.techchallenger4.logisticaentrega.infra.repository.EnderecoRepositoryImplJPA;
import br.com.fiap.techchallenger4.spring.consumer.CepConsumerFeignClient;
import br.com.fiap.techchallenger4.spring.jpa.repository.EnderecoRepositorySpring;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class ConfigBeans {
    
    @Bean
    EnderecoController enderecoController(@Autowired EnderecoService enderecoService, CepConsumerFeignClient cepConsumerFeignClient){
        return new EnderecoController(enderecoService, cepConsumerFeignClient);
    }

    @Bean
    EnderecoService enderecoService(@Autowired EnderecoRepository repository){
        return new EnderecoService(repository);
    }

    @Bean
    EnderecoRepository enderecoRepository(@Autowired EnderecoRepositorySpring repositorySpring){
        return new EnderecoRepositoryImplJPA(repositorySpring);
    }

    @Bean
    OpenAPI openAPI() { 
        return new OpenAPI()
            .info(new Info()
            .title("API de Logistica")
            .version("v1")
            .description("API de Logistica criada exclusivamente para o TechChallenge 4 da FIAP.")
        );
    }
}
