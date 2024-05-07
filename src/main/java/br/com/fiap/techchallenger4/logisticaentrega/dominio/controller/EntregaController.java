package br.com.fiap.techchallenger4.logisticaentrega.dominio.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EntregaService;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;

public class EntregaController {
    private final EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

    public EntregaEntity salvarEntregaEntity(EntregaEntity entregaEntity) throws BusinessException{
        final Entrega salvarEntrega = service.salvarEntrega(entregaEntity.to());
        return EntregaEntity.toEntity(salvarEntrega);
    }
}
