package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;


import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;

public class Entrega {
    private final Entregador entregador;
    private final Pedido pedido;

    public Entrega(Entregador entregador, Pedido pedido) {
		this.entregador = entregador;
		this.pedido = pedido;
	}

	public Entregador getEntregador() {
		return entregador;
	}


	public Pedido getPedido() {
		return pedido;
	}
}
