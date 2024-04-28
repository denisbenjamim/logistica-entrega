package br.com.fiap.techchallenger4.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.techchallenger4.spring.jpa.entity.PedidoEntity;


@Repository
public interface PedidoRepositorySpring extends JpaRepository<PedidoEntity, Long> {

}
