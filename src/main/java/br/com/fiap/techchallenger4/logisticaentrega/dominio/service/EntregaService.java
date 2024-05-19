package br.com.fiap.techchallenger4.logisticaentrega.dominio.service;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.AtualizarEntrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.BuscarEntrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.EncerrarEntrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

import java.util.List;

public class EntregaService {
    private final EntregaRepository repository;

    public EntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    public Entrega atualizarEntrega(Long idEntrega, Long idEntregador) throws BusinessException {
        return new AtualizarEntrega(repository).atualizar(idEntrega, idEntregador);
    }

    public Entrega getEntregaPorId(final Long codigoEntrega) throws BusinessException{
            return new BuscarEntrega(repository).buscarPorId(codigoEntrega);
    }

    public List<Entrega> getEntrega() throws BusinessException{
        return new BuscarEntrega(repository).buscarEntregaSemData();
    }

    public void encerrarEntrega(Long idEntrega) throws BusinessException {
        new EncerrarEntrega(repository).encerrar(idEntrega);
    }
}
