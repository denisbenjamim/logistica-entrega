package br.com.fiap.techchallenger4.spring.jpa.entity;

import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega.Entregador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class EntregadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntregador")
    private Long idEntregador;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "numeroTelefone")
    private String numeroTelefone;

    public EntregadorEntity(Long idEntregador, String nome, String cpf, String numeroTelefone) {
        this.idEntregador = idEntregador;
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;
    }

    public Entregador to() throws BusinessException {
        return new Entregador(idEntregador,nome, cpf, numeroTelefone);
    }

    public static EntregadorEntity toEntity(Entregador entregador) {
        return new EntregadorEntity(entregador.getIdEntregador(), entregador.getNome(),
                entregador.getCpf(),
                entregador.getNumeroTelefone());
    }


}
