package br.com.fiap.techchallenger4.logisticaentrega.infra.exception;

public class TechnicalException extends RuntimeException {
    
    public TechnicalException(Throwable throwable){
        super(throwable);
        throwable.printStackTrace();
    }

}
