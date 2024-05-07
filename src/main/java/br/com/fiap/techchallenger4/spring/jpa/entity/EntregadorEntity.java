package br.com.fiap.techchallenger4.spring.jpa.entity;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class EntregadorEntity {
    private String nome;
    private String cpf;
    private String numeroTelefone;

    public Entregador to(){
        return new Entregador(nome, cpf, numeroTelefone);
    }

    public static EntregadorEntity toEntity(Entregador entregador) {
        return EntregadorEntity.builder()
            .cpf(entregador.getCpf())
            .nome(entregador.getNome())
            .numeroTelefone(entregador.getNumeroTelefone())
        .build();
    }
}
