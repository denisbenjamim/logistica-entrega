package br.com.fiap.techchallenger4.logisticaentrega.infra.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.ObjectUtils;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.estrutura.exception.TechnicalException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;
import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import br.com.fiap.techchallenger4.spring.jpa.repository.EntregaRepositorySpring;


public class EntregaRepositoryImplJPA implements EntregaRepository {


    private final EntregaRepositorySpring entregaRepositorySpring;

    private final EntregadorRepository entregadorRepository;

    public EntregaRepositoryImplJPA(EntregaRepositorySpring entregaRepositorySpring, EntregadorRepository entregadorRepository) {
        this.entregaRepositorySpring = entregaRepositorySpring;
        this.entregadorRepository = entregadorRepository;
    }

    private void validarParametroNaoNuloOuZerado(Long parametro, String mensagemErro) throws BusinessException {
        if(parametro == null || parametro == 0) {
            throw new BusinessException(mensagemErro);
        }
    }

    private void validarEntregaNaBase(EntregaEntity objeto) throws BusinessException{
        if(objeto ==  null){
            throw new BusinessException("Id da entrega inexistente");
        }
    }
    @Override
    public Entrega atualizar(Long idEntrega, Long idEntregador) throws BusinessException {
       
        validarParametroNaoNuloOuZerado(idEntregador, "Código do entregador precisa ser válido.");

        Entregador entregador = entregadorRepository.buscarPorId(idEntregador);
        if(entregador == null) {
            throw new BusinessException("Entregador inexistente");
        }
        
        validarParametroNaoNuloOuZerado(idEntrega,"Id da entrega precisa ser válido!");

        EntregaEntity entregaAtualizada = entregaRepositorySpring.findByCodigoEntrega(idEntrega);
        validarEntregaNaBase(entregaAtualizada);

        try {
            entregaAtualizada.setEntregador(EntregadorEntity.toEntity(entregador));
            entregaAtualizada = entregaRepositorySpring.save(entregaAtualizada);
        }catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("Unique index or primary key violation")) {
                throw new BusinessException("O entregador já está vinculado a outra entrega.");
            } else {
                throw new BusinessException("Erro ao atualizar a entrega: " + e.getMessage());
             }
}
        
        return entregaAtualizada.to();
    }

    @Override
    public Entrega buscarPorId(Long codigoEntrega) throws BusinessException {
        
        validarParametroNaoNuloOuZerado(codigoEntrega, "Informe um código de entrega válido!");

        final EntregaEntity entrega = entregaRepositorySpring.findByCodigoEntrega(codigoEntrega);
        

        return entrega.to();
    }

    @Override
    public List<Entrega> buscarEntregaSemData() throws BusinessException {

        final List<EntregaEntity> entregaAll = entregaRepositorySpring.findAll();
        final List<Entrega> entregaList= new ArrayList<>();

        for(EntregaEntity entregaEntity: entregaAll) {
            entregaList.add(entregaEntity.toAll());
        }
        return entregaList;
    }

    

}