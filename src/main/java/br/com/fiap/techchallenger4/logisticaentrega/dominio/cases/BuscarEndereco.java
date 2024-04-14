package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import org.springframework.util.ObjectUtils;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;

public class BuscarEndereco {
    private final EnderecoRepository repository;

    public BuscarEndereco(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco buscarPorCEP(final String cep) throws BusinessException{
        if(ObjectUtils.isEmpty(cep)){
            throw new BusinessException("CEP é obrigatório para realizar a busca");
        }

        return repository.buscarPorCEP(cep);
    }
}
