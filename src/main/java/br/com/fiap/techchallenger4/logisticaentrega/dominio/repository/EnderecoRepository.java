package br.com.fiap.techchallenger4.logisticaentrega.dominio.repository;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.Endereco;

public interface EnderecoRepository {
    
    public Endereco buscarPorCEP(String cep);
    public Endereco criar(Endereco endereco);
   
}
