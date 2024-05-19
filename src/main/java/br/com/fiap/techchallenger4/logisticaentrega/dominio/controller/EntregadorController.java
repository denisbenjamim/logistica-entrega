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
        if(entregadorEntity.getIdEntregador() == null || entregadorEntity.getIdEntregador() == 0) {
            throw new BusinessException("Id do entregador Inválido");
        }
        final Entregador criarEntregador = entregadorService.criarEntregador(entregadorEntity.to());
        return EntregadorEntity.toEntity(criarEntregador);
    }

    public Entregador getEntregadorPorId(final Long idEntregador) throws BusinessException{
        if(idEntregador == null || idEntregador== 0){
            throw new BusinessException("Id de entregador inválido");
        }
        return entregadorService.getEntregadorPorId(idEntregador);
    }
}
