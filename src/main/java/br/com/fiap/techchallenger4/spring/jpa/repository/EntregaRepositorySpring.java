
package br.com.fiap.techchallenger4.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.techchallenger4.spring.jpa.entity.EntregaEntity;


public interface EntregaRepositorySpring extends JpaRepository<EntregaEntity, Long> {


    @Query("SELECT ee FROM EntregaEntity ee JOIN FETCH ee.pedido LEFT JOIN FETCH ee.entregador WHERE codigoEntrega =:codigoEntrega")
    public EntregaEntity findByCodigoEntrega(Long codigoEntrega);

}