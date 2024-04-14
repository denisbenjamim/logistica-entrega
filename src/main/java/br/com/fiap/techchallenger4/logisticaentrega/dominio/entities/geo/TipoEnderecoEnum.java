package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo;

public enum TipoEnderecoEnum {
    AEROPORTO("Aeroporto"),
    ALAMEDA("Alameda"),
    AREA("Área"),
    AVENIDA("Avenida"),
    CAMPO("Campo"),
    CHÁCARA("Chácara"),
    COLÔNIA("Colônia"),
    CONDOMÍNIO("Condomínio"),
    CONJUNTO("Conjunto"),
    DISTRITO("Distrito"),
    ESPLANADA("Esplanada"),
    ESTACAO("Estação"),
    ESTRADA("Estrada"),
    FAVELA("Favela"),
    FAZENDA("Fazenda"),
    FEIRA("Feira"),
    JARDIM("Jardim"),
    LADEIRA("Ladeira"),
    LAGO("Lago"),
    LAGOA("Lagoa"),
    LARGO("Largo"),
    LOTEAMENTO("Loteamento"),
    MORRO("Morro"),
    NUCLEO("Núcleo"),
    PARQUE("Parque"),
    PASSARELA("Passarela"),
    PATIO("Pátio"),
    PRACA("Praça"),
    QUADRA("Quadra"),
    RECANTO("Recanto"),
    RESIDENCIAL("Residencial"),
    RODOVIA("Rodovia"),
    RUA("Rua"),
    SETOR("Setor"),
    SITIO("Sítio"),
    TRAVESSA("Travessa"),
    TRECHO("Trecho"),
    TREVO("Trevo"),
    VALE("Vale"),
    VEREDA("Vereda"),
    VIA("Via"),
    VIADUTO("Viaduto"),
    VIELA("Viela"),
    VILA("Vila");

    private final String descricao;

    TipoEnderecoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

