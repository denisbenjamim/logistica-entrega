package br.com.fiap.techchallenger4.logisticaentrega.dominio.service;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.CriarEntrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

public class EntregaService {
    private final EntregaRepository repository;

    public EntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    public Entrega salvarEntrega(Entrega entrega){
        return new CriarEntrega(repository).executar(entrega);
    }
}
