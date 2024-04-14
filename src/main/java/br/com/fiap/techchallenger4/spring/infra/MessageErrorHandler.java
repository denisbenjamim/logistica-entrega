package br.com.fiap.techchallenger4.spring.infra;

public final class MessageErrorHandler {
	private final String message;

	private MessageErrorHandler(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public static MessageErrorHandler create(String message) {
		return new MessageErrorHandler(message);
	}
}