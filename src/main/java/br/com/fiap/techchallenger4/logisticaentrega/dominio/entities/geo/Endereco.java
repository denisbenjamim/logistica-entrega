package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import br.com.fiap.estrutura.exception.BusinessException;

public class Endereco implements CEP{
    private final String cep;
    private final double longitude;
    private final double latitude;
    private final EstadoBrasil estado;
    private final String nomeCidade;
    private final String nomeBairro;
    private final String nomeEndreco;
    private final TipoEnderecoEnum tipoEndereco;

    public Endereco(String cep, double longitude, double latitude, EstadoBrasil estado, String nomeCidade, String nomeBairro, String nomeEndreco, TipoEnderecoEnum tipoEndereco) throws BusinessException {
        cep = validarCEP(cep);

        if(longitude == 0){
            throw new BusinessException("Longitude é obrigatório");
        }

        if(latitude == 0){
            throw new BusinessException("Latitude é obrigatória");
        }

        if(Objects.isNull(estado)){
            throw new BusinessException("Estado é obrigatório");
        }

        
        if(StringUtils.isAllBlank(nomeCidade)){
            throw new BusinessException("Nome da cidade é obrigatório");
        }
       
        if(StringUtils.isAllBlank(nomeBairro)){
            throw new BusinessException("Nome do bairro é obrigatório");
        }

        if(StringUtils.isAllBlank(nomeEndreco)){
            throw new BusinessException("Nome do endereço é obrigatório");
        }

        if(Objects.isNull(tipoEndereco)){
            throw new BusinessException("Tipo do endereço é obrigatório");
        }
       
        this.cep = cep;
        this.longitude = longitude;
        this.latitude = latitude;
        this.estado = estado;
        this.nomeCidade = nomeCidade;
        this.nomeBairro = nomeBairro;
        this.nomeEndreco = nomeEndreco;
        this.tipoEndereco = tipoEndereco;
    }

    String validarCEP(String cep) throws BusinessException {
        if(StringUtils.isAllBlank(cep)){
            throw new BusinessException("CEP é obrigatório");
        }

        if(!cep.matches("\\d+")){
            cep = cep.trim().replaceAll("[^\\d]", "");
        }

        if(cep.length() != 8){
            throw new BusinessException("CEP deve ter 8 digitos");
        }

        return cep;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public EstadoBrasil getEstado() {
        return estado;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public String getNomeEndreco() {
        return nomeEndreco;
    }

    public TipoEnderecoEnum getTipoEndereco() {
        return tipoEndereco;
    }

    public String getCep() {
        return cep;
    }
}
