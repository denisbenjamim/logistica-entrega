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
        return entregaService.atualizarEntrega(idEntrega, idEntregador);
    }

    public void encerrarEntrega(Long idEntrega) throws BusinessException{
        entregaService.encerrarEntrega(idEntrega);
    }

    public Entrega getEntregaPorId(final Long codigoEntrega) throws BusinessException{
        
        if(codigoEntrega == null || codigoEntrega == 0){
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