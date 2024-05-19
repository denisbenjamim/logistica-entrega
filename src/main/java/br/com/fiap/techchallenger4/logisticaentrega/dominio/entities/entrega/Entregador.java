package br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.entrega;

import br.com.fiap.estrutura.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

public class Entregador {

    private Long idEntregador;
    private String nome;
    private String cpf;
    private String numeroTelefone;

    public Entregador(){}

    public Entregador(Long idEntregador, String nome, String cpf, String numeroTelefone) throws BusinessException {
        if(idEntregador == null){
            throw new BusinessException("Codigo do entregador nao pode ser nulo");
        } else if (StringUtils.isAllBlank(nome)) {
            throw new BusinessException("Nome é obrigatório");
        } else if (StringUtils.isAllBlank(cpf)) {
            throw new BusinessException("CPF é obrigatório");
        } else if (StringUtils.isAllBlank(numeroTelefone)) {
            throw new BusinessException("Número de telefone é obrigatório");
        }
        this.idEntregador = idEntregador;
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTelefone = numeroTelefone;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public Object toEntity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }
}
