package br.com.fiap.techchallenger4.spring.jpa.repository;

import br.com.fiap.techchallenger4.spring.jpa.entity.EntregadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepositorySpring extends JpaRepository<EntregadorEntity, Long> {

    public EntregadorEntity findByIdEntregador(Long idEntregador);

    public boolean existsByCpf(String cpf);

}
