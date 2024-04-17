package br.com.fiap.techchallenger4.spring.infra;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import br.com.fiap.techchallenger4.logisticaentrega.dominio.entities.geo.TipoEnderecoEnum;

public class CustomTipoLogradouradoDeserializer extends StdDeserializer<TipoEnderecoEnum> {

	private static final long serialVersionUID = 1L;

	protected CustomTipoLogradouradoDeserializer() {
		super(TipoEnderecoEnum.class);
	}

	@Override
	public TipoEnderecoEnum deserialize(JsonParser node, DeserializationContext ctxt) throws IOException, JacksonException {
		if(!StringUtils.isAllBlank(node.getText())) {
			for(TipoEnderecoEnum tipo : Arrays.asList(TipoEnderecoEnum.values())) {
				if(normalizarTexto(tipo.getDescricao()).equalsIgnoreCase(normalizarTexto(node.getText()))) {
					return tipo;
				}
			}
		}
		return null;
	}
	
	private String normalizarTexto(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        textoNormalizado = textoNormalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return textoNormalizado;
    }

	

}
