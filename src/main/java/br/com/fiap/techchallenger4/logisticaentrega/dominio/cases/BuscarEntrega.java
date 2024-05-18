package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

import java.util.List;

public class BuscarEntrega {

    private final EntregaRepository entregaRepository;

    public BuscarEntrega(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega buscarPorId(final Long codigoEntrega) throws BusinessException {
        if (codigoEntrega == null) {
            throw new BusinessException("Insira um código de entrega verdadeiro");
        }
        return entregaRepository.buscarPorId(codigoEntrega);
    }

    public List<Entrega> buscarEntregaSemData() throws BusinessException {
        return entregaRepository.buscarEntregaSemData();
    }
}
