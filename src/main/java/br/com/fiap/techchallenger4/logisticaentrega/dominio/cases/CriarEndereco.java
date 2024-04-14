package br.com.fiap.techchallenger4.logisticaentrega.dominio.cases;

import org.springframework.util.ObjectUtils;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;

public class CriarEndereco {
    private final EnderecoRepository repository;

    public CriarEndereco(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco criar(final Endereco endereco) throws BusinessException{
        if(ObjectUtils.isEmpty(endereco)){
            throw new BusinessException("Endereço é obrigatório na criaçao do mesmo");
        }

        return repository.criar(null);
    }
}
