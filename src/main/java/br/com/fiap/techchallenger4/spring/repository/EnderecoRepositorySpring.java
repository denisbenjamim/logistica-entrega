package br.com.fiap.techchallenger4.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.techchallenger4.logisticaentrega.infra.jpa.entity.EnderecoEntity;

@Repository
public interface EnderecoRepositorySpring extends JpaRepository<EnderecoEntity, String> {
    public EnderecoEntity findByCep(String cep);
}
