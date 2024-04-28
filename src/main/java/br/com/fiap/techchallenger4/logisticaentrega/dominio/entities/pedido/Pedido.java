package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private final long codigoPedido;
    private final long codigoCliente;
    private final String statusPedido;
    private final LocalDateTime dataEntrega;
    private final LocalDateTime dataEnvio;
    private final List<Produto> itens;
    
    private EnderecoPedido endereco;

	public Pedido(
		long codigoPedido, 
		long codigoCliente, 
		String statusPedido, 
		LocalDateTime dataEntrega,
		LocalDateTime dataEnvio,
		EnderecoPedido endereco,
		List<Produto> itens
	) {
		this.codigoPedido = codigoPedido;
		this.codigoCliente = codigoCliente;
		this.statusPedido = statusPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.endereco = endereco;
		this.itens = itens == null ? new ArrayList<>() : itens;
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

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}
}
