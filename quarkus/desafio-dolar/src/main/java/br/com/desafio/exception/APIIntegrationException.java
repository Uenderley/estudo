package br.com.desafio.exception;

public class APIIntegrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public APIIntegrationException(String message) {
        super(message);
    }
}
