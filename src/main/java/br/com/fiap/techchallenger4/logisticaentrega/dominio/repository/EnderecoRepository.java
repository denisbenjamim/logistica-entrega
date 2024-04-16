package br.com.fiap.techchallenger4.logisticaentrega.dominio.repository;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;

public interface EnderecoRepository {
    
    public Endereco buscarPorCEP(String cep) throws BusinessException;
    public Endereco criar(Endereco endereco) throws BusinessException;
   
}
