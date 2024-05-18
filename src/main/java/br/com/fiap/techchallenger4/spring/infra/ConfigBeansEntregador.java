package br.com.fiap.techchallenger4.spring.infra;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EntregadorController;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EntregadorService;
import br.com.fiap.techchallenger4.logisticaentrega.infra.repository.EntregadorRepositoryImplJPA;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregadorRepositorySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeansEntregador {

    @Bean
    EntregadorController entregadorController(@Autowired EntregadorService entregadorService) {
        return new EntregadorController(entregadorService);
    }

    @Bean
    EntregadorService entregadorService(@Autowired EntregadorRepository entregadorRepository) {
        return new EntregadorService(entregadorRepository);
    }

    @Bean
    EntregadorRepository entregadorRepository(@Autowired EntregadorRepositorySpring entregadorRepositorySpring) {
        return new EntregadorRepositoryImplJPA(entregadorRepositorySpring);
    }
}
