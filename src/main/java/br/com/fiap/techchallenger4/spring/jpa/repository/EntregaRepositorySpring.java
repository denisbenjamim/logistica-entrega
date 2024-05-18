
package br.com.fiap.techchallenger4.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;

import java.util.List;

public interface EntregaRepositorySpring extends JpaRepository<EntregaEntity, Long> {
    public EntregaEntity findByCodigoEntrega(Long codigoEntrega);

    public List<EntregaEntity> findAllByDataEntregaIsNull();

}