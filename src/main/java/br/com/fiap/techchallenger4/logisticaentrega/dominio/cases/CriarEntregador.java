package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregadorRepository;

public class CriarEntregador {

    private final EntregadorRepository repository;

    public CriarEntregador(EntregadorRepository repository) {
        this.repository = repository;
    }

    public Entregador criar(Entregador entregador) throws BusinessException{
        return repository.criar(entregador);
    }
}
