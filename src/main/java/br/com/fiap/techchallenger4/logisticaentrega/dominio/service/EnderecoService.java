package br.com.fiap.techchallenger4.logisticaentrega.dominio.service;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.cases.BuscarEndereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;

public class EnderecoService {
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco getEnderecoPeloCep(final String cep) throws BusinessException{
		return new BuscarEndereco(repository).buscarPorCEP(cep);
    }
    
    public Endereco salvarEndereco(Endereco endereco) {
    	return repository.criar(endereco);
    }
    
}