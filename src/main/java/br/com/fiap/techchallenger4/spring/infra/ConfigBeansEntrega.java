package br.com.fiap.techchallenger4.spring.infra;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.controller.EntregaController;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EntregaService;
import br.com.fiap.techchallenger4.logisticaentrega.infra.repository.EntregaRepositoryImplJPA;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregaRepositorySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeansEntrega {

    @Bean
    EntregaController entregaController(@Autowired EntregaService entregaService) {
        return new EntregaController(entregaService);
    }

    @Bean
    EntregaService entregaService(@Autowired EntregaRepository entregaRepository) {
        return new EntregaService(entregaRepository);
    }

    @Bean
    EntregaRepository entregaRepository(@Autowired EntregaRepositorySpring entregaRepositorySpring, @Autowired EntregadorRepository entregadorRepository) {
        return new EntregaRepositoryImplJPA(entregaRepositorySpring, entregadorRepository);
    }
}