package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;

public class BuscarEntregador {

    private final EntregadorRepository entregadorRepository;

    public BuscarEntregador(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public Entregador buscarPorId(final Long idEntregador) throws BusinessException {
        if (idEntregador == null) {
            throw new BusinessException("Insira um codigo de entregador válido");
        }
        return entregadorRepository.buscarPorId(idEntregador);
    }
}
