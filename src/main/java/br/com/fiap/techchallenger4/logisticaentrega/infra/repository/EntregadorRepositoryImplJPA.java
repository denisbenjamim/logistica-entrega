package br.com.fiap.techchallenger4.logisticaentrega.infra.repository;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregadorRepositorySpring;
import org.springframework.util.ObjectUtils;

public class EntregadorRepositoryImplJPA implements EntregadorRepository {

    private final EntregadorRepositorySpring entregadorRepositorySpring;

    public EntregadorRepositoryImplJPA(EntregadorRepositorySpring entregadorRepositorySpring) {
        this.entregadorRepositorySpring = entregadorRepositorySpring;
    }

    @Override
    public Entregador criar(Entregador entregador) throws BusinessException {
        return entregadorRepositorySpring.save(EntregadorEntity.toEntity(entregador)).to();
    }

    public Entregador buscarPorId(Long idEntregador) throws BusinessException {
        final EntregadorEntity entregador = entregadorRepositorySpring.findByIdEntregador(idEntregador);
        if (ObjectUtils.isEmpty(entregador)){
            return null;
        }
        return entregador.to();
    }
}
