package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;


import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;

import java.util.Objects;

public class Entrega {
	private long codigoEntrega;
    private Entregador entregador;
    private Pedido pedido;

	public Entrega() {}

	public Entrega(long codigoEntrega, Entregador entregador, Pedido pedido) throws BusinessException {
        if(codigoEntrega <= 0){
			throw new BusinessException("Codigo de Entrega nao pode ser menor ou igual a zero");
		} 
		
		if (Objects.isNull(pedido)) {
			throw new BusinessException("Código pedido é obrigatório");
		}
		this.codigoEntrega = codigoEntrega;
		this.entregador = entregador;
		this.pedido = pedido;
	}

    public Entregador getEntregador() {
		return entregador;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public long getCodigoEntrega() {
		return codigoEntrega;
	}
}
