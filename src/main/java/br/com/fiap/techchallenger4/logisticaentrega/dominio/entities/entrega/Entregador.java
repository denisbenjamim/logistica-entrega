package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;

public class Entregador {
    private final String nome;
    private final String cpf;
    private final String numeroTelefone;
    
    public Entregador(String nome, String cpf, String numeroTelefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.numeroTelefone = numeroTelefone;
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
