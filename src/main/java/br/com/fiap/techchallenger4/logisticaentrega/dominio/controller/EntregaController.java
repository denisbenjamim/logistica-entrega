package br.com.fiap.techchallenger4.logisticaentrega.dominio.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EntregaService;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;

import java.util.List;

public class EntregaController {
    private final EntregaService entregaService;

    public EntregaController(EntregaService service) {

        this.entregaService = service;
    }

    public Entrega atualizarEntrega(Long idEntrega, Long idEntregador) throws BusinessException{
        final Entrega atualizarEntrega = entregaService.atualizarEntrega(idEntrega, idEntregador);
        return atualizarEntrega;
    }

    public Entrega getEntregaPorId(final Long codigoEntrega) throws BusinessException{
        Entrega entregaPorId = entregaService.getEntregaPorId(codigoEntrega);
        return entregaPorId;
    }

    public List<Entrega> getAll() throws BusinessException{
        List<Entrega> entrega = entregaService.getEntrega();
        return entrega;

    }
}