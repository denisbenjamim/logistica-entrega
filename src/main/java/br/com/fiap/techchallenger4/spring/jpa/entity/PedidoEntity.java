package br.com.fiap.techchallenger4.spring.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.EnderecoPedido;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Produto;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "tb_pedidos")
@Entity
public class PedidoEntity {
    @Id
    @Column(name="cd_pedido", unique = true)
    private Long codigoPedido;
    
    @Column(name="cd_cliente", nullable = false)
    private Long codigoCliente;
    
    @Column(name = "dt_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    
    @Column(name = "ds_status_pedido", nullable = false)
    private String statusPedido;

    @Column(name = "cd_cep", nullable = false)
    private String cep;

    @Column(name = "nr_endereco", nullable = false)
    private String numeroEndereco;

    @Column(name = "ds_complemento_endereco")
	private String complementoEndereco;

    @ElementCollection
    @CollectionTable(
        name = "tb_pedido_produtos",
        joinColumns = @JoinColumn(name = "cd_pedido"),
        foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUTO"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"cd_pedido","cd_produto"}) 
    )
    private List<PedidoProdutoEmbeddable> produtos = new ArrayList<>();

    public Pedido to(){
        final List<Produto> produtoList =  produtos.stream().map(p -> new Produto(p.getCodigoProduto(), p.getQuantidade())).toList();
        final EnderecoPedido enderecoPedido = new EnderecoPedido(numeroEndereco, complementoEndereco, cep);
        return new Pedido(codigoPedido, codigoCliente, statusPedido, dataCriacao, null, enderecoPedido, produtoList);
    }

    public static PedidoEntity toEntity(Pedido pedido){
        final List<PedidoProdutoEmbeddable> produtoList = pedido.getItens().stream().map(p -> new PedidoProdutoEmbeddable(p.getCodigoProduto(), p.getQuantidade())).toList();
        return new PedidoEntity(
            pedido.getCodigoPedido(), 
            pedido.getCodigoCliente(), 
            null, 
            pedido.getStatusPedido(), 
            pedido.getEndereco().getCep(), 
            pedido.getEndereco().getNumero(), 
            pedido.getEndereco().getComplemento(), 
            produtoList
        );
    }
}
