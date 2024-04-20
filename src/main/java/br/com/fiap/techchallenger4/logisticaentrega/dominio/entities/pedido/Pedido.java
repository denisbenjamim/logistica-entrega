package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private long codigoPedido;
    private long codigoCliente;
    private String statusPedido = "AGUARDANDO_ENVIO";
    private LocalDateTime dataEnvio;
    private List<Produto> itens = new ArrayList<>();
    
    private EnderecoPedido endereco;

	public Pedido(
		long codigoPedido, 
		long codigoCliente, String statusPedido, LocalDateTime dataEnvio,
			List<Produto> itens, EnderecoPedido endereco) {
		this.codigoPedido = codigoPedido;
		this.codigoCliente = codigoCliente;
		this.statusPedido = statusPedido;
		this.dataEnvio = dataEnvio;
		this.itens = itens;
		this.endereco = endereco;
	}

	public long getCodigoPedido() {
		return codigoPedido;
	}

	public long getCodigoCliente() {
		return codigoCliente;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public EnderecoPedido getEndereco() {
		return endereco;
	}
}
