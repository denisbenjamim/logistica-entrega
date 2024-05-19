package br.com.fiap.techchallenger4.spring.jpa.entity;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    public Entrega toAll() throws BusinessException{
        return new Entrega(this.codigoEntrega, this.entregador.to(), this.pedido.to());
    }

    public static EntregaEntity toEntity(Entrega entrega){
        return new EntregaEntity(entrega.getCodigoEntrega(),
        EntregadorEntity.toEntity(entrega.getEntregador()),
        PedidoEntity.toEntity(entrega.getPedido()));
    }
    @PrePersist
    public void gravarDataEntrega(){
        setDataEntrega(LocalDateTime.now());
    }

    public EntregaEntity(long codigoEntrega2, EntregadorEntity entregadorEntity, PedidoEntity pedidoEntity) {
        
    }
}
