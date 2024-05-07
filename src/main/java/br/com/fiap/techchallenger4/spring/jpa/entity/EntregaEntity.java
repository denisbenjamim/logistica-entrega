package br.com.fiap.techchallenger4.spring.jpa.entity;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entrega;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
}
