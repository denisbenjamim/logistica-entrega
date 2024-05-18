package br.com.fiap.techchallenger4.logisticaentrega.dominio.service;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.BuscarEntregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.CriarEntregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;

public class EntregadorService {

    private final EntregadorRepository entregadorRepository;

    public EntregadorService(EntregadorRepository entregadorRepository){this.entregadorRepository = entregadorRepository;}

    public Entregador criarEntregador(Entregador entregador) throws BusinessException {
        return new CriarEntregador(entregadorRepository).criar(entregador);
    }

    public Entregador getEntregadorPorId(final Long idEntregador) throws BusinessException {
        return new BuscarEntregador(entregadorRepository).buscarPorId(idEntregador);
    }
}
