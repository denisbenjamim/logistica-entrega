package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

public class EnderecoPedido  {

	private final String numero;
	private final String complemento;
	private final String cep;
	
	public EnderecoPedido(String numero, String complemento, String cep) {
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}
}
