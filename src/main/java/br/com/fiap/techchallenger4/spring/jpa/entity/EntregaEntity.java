package br.com.fiap.techchallenger4.spring.jpa.entity;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_entrega")
public class EntregaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_entrega")
    private Long codigoEntrega;

    @OneToOne
    @JoinColumn(name = "cd_entregador")
    private EntregadorEntity entregador;

    @OneToOne
    @JoinColumn(name = "cd_pedido")
    private PedidoEntity pedido;

    @Column(name = "data_entrega")
    private LocalDateTime dataEntrega;

    public EntregaEntity(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public Entrega to() throws BusinessException{
        return new Entrega(codigoEntrega, entregador.to(), pedido.to());
    }

    public static EntregaEntity toEntity(Entrega entrega){
        return EntregaEntity.builder()
            .codigoEntrega(entrega.getCodigoEntrega())
            .pedido(PedidoEntity.toEntity(entrega.getPedido()))
            .entregador(EntregadorEntity.toEntity(entrega.getEntregador()))
        .build();
    }
    @PrePersist
    public void gravarDataEntrega(){
        setDataEntrega(LocalDateTime.now());
    }
}
