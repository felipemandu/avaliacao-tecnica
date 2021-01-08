package br.com.navita.patrimonioempresa.exceptions;

@SuppressWarnings("serial")
public class MarcaAlreadyExistsException extends RuntimeException {

	public MarcaAlreadyExistsException(String msg) {
		super(msg);
	}
}
