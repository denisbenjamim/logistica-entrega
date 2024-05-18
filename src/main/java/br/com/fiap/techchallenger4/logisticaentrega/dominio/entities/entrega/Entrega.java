package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;


import br.com.fiap.estrutura.exception.BusinessException;
import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;

import java.time.LocalDate;

public class Entrega {
	private final long codigoEntrega;
    private final Entregador entregador;
    private final Pedido pedido;

	public Entrega(long codigoEntrega, Entregador entregador, Pedido pedido) throws BusinessException {
        if(codigoEntrega <= 0){
			throw new BusinessException("Codigo de Entrega nao pode ser menor ou igual a zero");
		} else if (entregador == null) {
			throw new BusinessException("Código entregador deve ser válido");
		} else if (pedido == null) {
			throw new BusinessException("Código pedido deve ser válido");
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
