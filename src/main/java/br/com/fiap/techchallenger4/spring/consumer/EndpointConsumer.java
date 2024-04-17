package br.com.fiap.techchallenger4.spring.consumer;

public class EndpointConsumer {
    private final String urlEndpoint;
    
    public EndpointConsumer(String urlEndpoint) {
        this.urlEndpoint = urlEndpoint;
    }

    public String getUrlEndpoint() {
        return urlEndpoint;
    }
}
