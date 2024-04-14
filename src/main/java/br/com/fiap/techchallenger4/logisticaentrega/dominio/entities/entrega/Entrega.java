package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;


import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido.Pedido;

public class Entrega {
    private Entregador entregador;
    private StatusEntrega statusEntrega; 
    private Pedido pedido;
    
    public Entregador getEntregador() {
        return entregador;
    }
    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }
    public Pedido getPedido() {
        return pedido;
    }

    
}
