package br.com.caixavidaeprevidencia.desafio.caixa.exceptions;

public class SemResultadoException extends CaixaException {

	private static final long serialVersionUID = 5621857363981951899L;
	
	public SemResultadoException() {
		super();
	}

	public SemResultadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public SemResultadoException(String message) {
		super(message);
	}

	public SemResultadoException(Throwable cause) {
		super(cause);
	}

}
