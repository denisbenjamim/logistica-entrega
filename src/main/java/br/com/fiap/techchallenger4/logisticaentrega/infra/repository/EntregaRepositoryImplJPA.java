package br.com.fiap.techchallenger4.logisticaentrega.infra.repository;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregaRepositorySpring;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class EntregaRepositoryImplJPA implements EntregaRepository {

    private final EntregaRepositorySpring entregaRepositorySpring;

    private final EntregadorRepository entregadorRepository;

    public EntregaRepositoryImplJPA(EntregaRepositorySpring entregaRepositorySpring, EntregadorRepository entregadorRepository) {
        this.entregaRepositorySpring = entregaRepositorySpring;
        this.entregadorRepository = entregadorRepository;
    }

    @Override
    public Entrega atualizar(Long idEntrega, Long idEntregador) throws BusinessException {

        if(idEntregador == null) {
            throw new BusinessException("Código entregador precisa ser válido.");
        }
        Entregador entregador = entregadorRepository.buscarPorId(idEntregador);

        if(entregador == null) {
            throw new BusinessException("Entregador inexistente");
        }
        EntregaEntity entregaAtualizada = new EntregaEntity();
        entregaAtualizada.setEntregador(EntregadorEntity.toEntity(entregador));

        entregaRepositorySpring.save(entregaAtualizada);
        return entregaAtualizada.to();
    }

    @Override
    public Entrega buscarPorId(Long codigoEntrega) throws BusinessException {

        if(codigoEntrega == null){
            throw new BusinessException("Informe um código de entrega válido!");
        }

        final EntregaEntity entrega = entregaRepositorySpring.findByCodigoEntrega(codigoEntrega);

        if(ObjectUtils.isEmpty(entrega)){
            return null;
        }
        return entrega.to();
    }

    @Override
    public List<Entrega> buscarEntregaSemData() throws BusinessException {
        final List<EntregaEntity> entregaAll = entregaRepositorySpring.findAllByDataEntregaIsNull();
        final List<Entrega> entregaList= new ArrayList<>();

        for(EntregaEntity entregaEntity: entregaAll) {
            entregaList.add(entregaEntity.to());
        }
        return entregaList;
    }
}