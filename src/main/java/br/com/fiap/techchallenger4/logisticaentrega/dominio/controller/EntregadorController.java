package br.com.fiap.techchallenger4.logisticaentrega.dominio.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EntregadorService;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;

public class EntregadorController {

    private final EntregadorService entregadorService;

    public EntregadorController(EntregadorService entregadorService) {
        this.entregadorService = entregadorService;
    }

    public EntregadorEntity criarEntregadorEntity(EntregadorEntity entregadorEntity) throws BusinessException {
        final Entregador criarEntregador = entregadorService.criarEntregador(entregadorEntity.to());
        return EntregadorEntity.toEntity(criarEntregador);
    }

    public Entregador getEntregadorPorId(final Long idEntregador) throws BusinessException{
        Entregador entrgadorPorId = entregadorService.getEntregadorPorId(idEntregador);
        return entrgadorPorId;
    }
}
