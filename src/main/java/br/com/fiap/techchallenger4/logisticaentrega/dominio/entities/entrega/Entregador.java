package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;

public class Entregador {

    private final Long idEntregador;
    private final String nome;
    private final String cpf;
    private final String numeroTelefone;

    public Entregador(Long idEntregador, String nome, String cpf, String numeroTelefone) {
        this.idEntregador = idEntregador;
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }
}
