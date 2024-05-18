package br.com.fiap.techchallenger4.logisticaentrega.dominio.repository;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;

public interface EntregadorRepository {

    public Entregador criar(Entregador entregador) throws BusinessException;
    public Entregador buscarPorId(Long idEntregador) throws BusinessException;
}
