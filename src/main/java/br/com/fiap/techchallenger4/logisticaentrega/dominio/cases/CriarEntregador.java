package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;
import org.springframework.util.ObjectUtils;


public class CriarEntregador {

    private final EntregadorRepository repository;

    public CriarEntregador(EntregadorRepository repository) {
        this.repository = repository;
    }

    public Entregador criar(Entregador entregador) throws BusinessException{
        if(ObjectUtils.isEmpty(entregador)){
            throw new BusinessException("Entregador é obrigatório para ser criado");
        }
        return repository.criar(entregador);
    }
}
