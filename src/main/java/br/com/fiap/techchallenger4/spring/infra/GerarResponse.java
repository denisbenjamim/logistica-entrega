package br.com.fiap.techchallenger4.spring.infra;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.exception.BusinessException;

@FunctionalInterface
public interface GerarResponse<T> {

	T get() throws  BusinessException;
}
