package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.pedido;


public class Produto {
    private long codigoProduto;
    private long quantidade;
    
	public Produto(long codigoProduto, long quantidade) {
		
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
	}
	
	public Produto(String string, int quantidade2) {
    }

    public long getCodigoProduto() {
		return codigoProduto;
	}
	
	public long getQuantidade() {
		return quantidade;
	}
    
}
