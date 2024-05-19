package br.com.fiap.techchallenger4.logisticaentrega.infra.repository;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregadorRepositorySpring;

public class EntregadorRepositoryImplJPA implements EntregadorRepository {

    private final EntregadorRepositorySpring entregadorRepositorySpring;

    public EntregadorRepositoryImplJPA(EntregadorRepositorySpring entregadorRepositorySpring) {
        this.entregadorRepositorySpring = entregadorRepositorySpring;
    }


    @Override
    public Entregador criar(Entregador entregador) throws BusinessException {
        String cpf = entregador.getCpf();
        Long id = entregador.getIdEntregador();
        if(entregadorRepositorySpring.existsByCpf(cpf)) {
            throw new BusinessException("CPF já em uso por outro entregador");
        } else if(entregadorRepositorySpring.existsById(id)){
            throw new BusinessException("Id já existente na base de dados");
        }
        return entregadorRepositorySpring.save(EntregadorEntity.toEntity(entregador)).to();
    }

    @Override
    public Entregador buscarPorId(Long idEntregador) throws BusinessException {
        final EntregadorEntity entregador = entregadorRepositorySpring.findByIdEntregador(idEntregador);
        if (entregador == null){
            throw new BusinessException("Id do entregador inexistente");
        }
        return entregador.to();
    }
}
