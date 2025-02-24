package br.com.caixavidaeprevidencia.desafio.caixa.exceptions;

public class ValidacaoException extends CaixaException {

	private static final long serialVersionUID = 5621857363981951899L;
	
	public ValidacaoException() {
		super();
	}

	public ValidacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidacaoException(String message) {
		super(message);
	}

	public ValidacaoException(Throwable cause) {
		super(cause);
	}

}
