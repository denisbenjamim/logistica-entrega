package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

public class EnderecoPedido  {

	private String numero;
	private String complemento;
	private String cep;
	
	public EnderecoPedido(){}

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
