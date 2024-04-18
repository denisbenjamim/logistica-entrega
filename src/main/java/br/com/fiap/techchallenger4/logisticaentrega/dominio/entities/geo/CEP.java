package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo;

import br.com.fiap.estrutura.exception.BusinessException;

public interface CEP {
    
    public double getLongitude();

    public double getLatitude();

    public EstadoBrasil getEstado();

    public String getNomeCidade();

    public String getNomeBairro();

    public String getNomeEndreco();

    public TipoEnderecoEnum getTipoEndereco();

    public String getCep();
    
    public default Endereco toEndereco() throws BusinessException {
    	return new Endereco(getCep(), getLongitude(), getLatitude(), getEstado(), getNomeCidade(), getNomeBairro(), getNomeEndreco(), getTipoEndereco());
    }
}
