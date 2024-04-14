package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo;

import java.util.Objects;

import org.springframework.util.ObjectUtils;

public class Endereco implements CEP{
    private final String cep;
    private final double longitude;
    private final double latitude;
    private final EstadoBrasil estado;
    private final String nomeCidade;
    private final String nomeBairro;
    private final String nomeEndreco;
    private final TipoEnderecoEnum tipoEndereco;

    public Endereco(String cep, double longitude, double latitude, EstadoBrasil estado, String nomeCidade, String nomeBairro, String nomeEndreco, TipoEnderecoEnum tipoEndereco) {
        if(ObjectUtils.isEmpty(cep)){
            throw new IllegalArgumentException("Nome da cidade é obrigatório");
        }

        if(longitude == 0){
            throw new IllegalArgumentException("Longitude é obrigatório");
        }

        if(latitude == 0){
            throw new IllegalArgumentException("Latitude é obrigatória");
        }

        if(Objects.isNull(estado)){
            throw new IllegalArgumentException("Estado é obrigatório");
        }

        if(ObjectUtils.isEmpty(nomeCidade)){
            throw new IllegalArgumentException("Nome da cidade é obrigatório");
        }
       
        if(ObjectUtils.isEmpty(nomeBairro)){
            throw new IllegalArgumentException("Nome do bairro é obrigatório");
        }

        if(ObjectUtils.isEmpty(nomeEndreco)){
            throw new IllegalArgumentException("Nome do endereço é obrigatório");
        }

        if(Objects.isNull(tipoEndereco)){
            throw new IllegalArgumentException("Tipo do endereço é obrigatório");
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
