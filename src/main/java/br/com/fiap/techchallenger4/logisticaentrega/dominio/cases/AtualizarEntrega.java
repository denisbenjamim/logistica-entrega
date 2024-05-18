package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

public class AtualizarEntrega {

    private final EntregaRepository repository;

    public AtualizarEntrega(EntregaRepository repository) {
        this.repository = repository;
    }

    public Entrega atualizar(Long idEntrega, Long idEntregador) throws BusinessException {
        if (idEntrega == null){
            throw new BusinessException("Id da entrega deve ser válido");
        } else if (idEntregador == null) {
            throw new BusinessException("Id de entregador deve ser válido");
        }
        return repository.atualizar(idEntrega, idEntregador);
    }
}
