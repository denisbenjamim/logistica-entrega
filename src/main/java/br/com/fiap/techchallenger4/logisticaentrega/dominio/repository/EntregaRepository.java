package br.com.fiap.techchallenger4.logisticaentrega.dominio.repository;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;

import java.util.List;

public interface EntregaRepository {

    public Entrega atualizar(Long idEntrega, Long idEntregador) throws BusinessException;
    
    public Entrega buscarPorId(Long codigoEntrega) throws BusinessException;

    List<Entrega> buscarEntregaSemData() throws BusinessException;

}
