package br.com.fiap.techchallenger4.spring.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EnderecoController;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EnderecoService;
import br.com.fiap.techchallenger4.logisticaentrega.infra.repository.EnderecoRepositoryImplJPA;
import br.com.fiap.techchallenger4.spring.repository.EnderecoRepositorySpring;
import br.com.fiap.techchallenger4.spring.service.ConsumerCEP;

@Configuration
public class ConfigBeans {
    
    @Bean
    EnderecoController enderecoController(@Autowired EnderecoService enderecoService,@Autowired  ConsumerCEP consumerCEP){
        return new EnderecoController(enderecoService, consumerCEP);
    }

    @Bean
    EnderecoService enderecoService(@Autowired EnderecoRepository repository){
        return new EnderecoService(repository);
    }

    @Bean
    EnderecoRepository enderecoRepository(@Autowired EnderecoRepositorySpring repositorySpring){
        return new EnderecoRepositoryImplJPA(repositorySpring);
    }
}
