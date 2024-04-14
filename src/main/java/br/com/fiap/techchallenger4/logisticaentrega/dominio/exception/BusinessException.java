package br.com.fiap.techchallenger4.logisticaentrega.dominio.exception;

public class BusinessException extends Exception {
    public BusinessException(final String message){
        super(message);
    }
}
