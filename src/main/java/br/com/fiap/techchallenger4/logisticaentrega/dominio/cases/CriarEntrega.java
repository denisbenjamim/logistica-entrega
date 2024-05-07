package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

public class CriarEntrega {
    
    private final EntregaRepository repository;

    public CriarEntrega(EntregaRepository repository) {
        this.repository = repository;
    }

    public Entrega executar(Entrega entrega){
        return repository.criar(entrega);
    }
}
