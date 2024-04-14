package br.com.fiap.techchallenger4.spring.consumer;

import java.util.HashMap;
import java.util.Map;

public class EndpointConsumer {
    private final String urlEndpoint;
    private final Map<String,String> headers = new HashMap<>();
    private final Map<String,String> queryPameters = new HashMap<>();
    
    public EndpointConsumer(String urlEndpoint) {
        this.urlEndpoint = urlEndpoint;
    }

    public EndpointConsumer addHeader(final String key, final String value){
        this.headers.put(key, value);
        return this;
    }

    public EndpointConsumer addQueryParameter(final String key, final String value){
        this.queryPameters.put(key, value);
        return this;
    }

    public String getUrlEndpoint() {
        return urlEndpoint;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryPameters() {
        return queryPameters;
    }
}
