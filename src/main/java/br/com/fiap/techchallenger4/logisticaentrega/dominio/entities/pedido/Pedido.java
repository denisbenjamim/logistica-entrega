package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private long codigoPedido;
    private long codigoCliente;
    private String statusPedido;
    private LocalDateTime dataEntrega;
    private LocalDateTime dataEnvio;
    private List<Produto> itens;
    
    private EnderecoPedido endereco;

	public Pedido(){}

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
