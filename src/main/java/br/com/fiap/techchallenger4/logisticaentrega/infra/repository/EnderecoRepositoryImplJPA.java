package br.com.fiap.techchallenger4.logisticaentrega.infra.repository;

import org.springframework.util.ObjectUtils;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.repository.EnderecoRepository;
import br.com.fiap.techchallenger4.logisticaentrega.infra.jpa.entity.EnderecoEntity;
import br.com.fiap.techchallenger4.spring.repository.EnderecoRepositorySpring;

public class EnderecoRepositoryImplJPA implements EnderecoRepository {

    private final EnderecoRepositorySpring repositorySpring;

    
    public EnderecoRepositoryImplJPA(EnderecoRepositorySpring repositorySpring) {
        this.repositorySpring = repositorySpring;
    }

    @Override
    public Endereco buscarPorCEP(String cep) throws BusinessException {
        final EnderecoEntity endereco = repositorySpring.findByCep(cep);
       
        if(ObjectUtils.isEmpty(endereco)){
            return null;
        }
        return endereco.to();
    }

	@Override
	public Endereco criar(Endereco endereco) throws BusinessException {
		return repositorySpring.save(EnderecoEntity.to(endereco)).to();
	}
    
}
