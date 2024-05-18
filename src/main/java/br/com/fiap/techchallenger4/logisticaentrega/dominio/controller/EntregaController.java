package br.com.fiap.techchallenger4.logisticaentrega.dominio.controller;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.service.EntregaService;

import java.util.List;

public class EntregaController {
    private final EntregaService entregaService;

    public EntregaController(EntregaService service) {

        this.entregaService = service;
    }

    public Entrega atualizarEntrega(Long idEntrega, Long idEntregador) throws BusinessException{

        if(idEntrega == null){
            throw new BusinessException("Informe um id de entrega válido!");
        } else if (idEntregador == null) {
            throw new BusinessException("Informe um id de entregador válido");
        }
        return entregaService.atualizarEntrega(idEntrega, idEntregador);
    }

    public Entrega getEntregaPorId(final Long codigoEntrega) throws BusinessException{

        if(codigoEntrega == null){
            throw new BusinessException("Informe um código de entrega válido!");
        }
        return entregaService.getEntregaPorId(codigoEntrega);
    }

    public List<Entrega> getAll() throws BusinessException{
        List<Entrega> entrega = entregaService.getEntrega();
        if(entrega.isEmpty()){
            throw new BusinessException("Nenhuma entrega encontrada!");
        }
        return entrega;

    }
}