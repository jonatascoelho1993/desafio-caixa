package br.com.caixavidaeprevidencia.desafio.caixa.exceptions;

public class CaixaException extends Exception {

	private static final long serialVersionUID = -8332246097963713755L;

	public CaixaException() {
		super();
	}

	public CaixaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CaixaException(String message) {
		super(message);
	}

	public CaixaException(Throwable cause) {
		super(cause);
	}

}
