package br.com.fiap.techchallenger4.spring.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class PedidoProdutoEmbeddable {
    @Column(nullable = false, name = "cd_produto")
    private Long codigoProduto;
    
    @Column(nullable = false, name = "qt_produto")
    private Long quantidade;
}
