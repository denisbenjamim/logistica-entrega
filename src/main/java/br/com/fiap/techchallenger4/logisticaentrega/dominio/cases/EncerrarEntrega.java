package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EntregaRepository;

public class EncerrarEntrega {

    private final EntregaRepository repository;

    public EncerrarEntrega(EntregaRepository repository) {
        this.repository = repository;
    }

    public void encerrar(Long idEntrega) throws BusinessException {
        if (idEntrega == null){
            throw new BusinessException("Id da entrega deve ser válido");
        } 
        repository.encerrar(idEntrega);
    }
}
