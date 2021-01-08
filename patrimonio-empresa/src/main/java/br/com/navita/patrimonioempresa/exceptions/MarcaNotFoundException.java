package br.com.navita.patrimonioempresa.exceptions;

@SuppressWarnings("serial")
public class MarcaNotFoundException extends RuntimeException {

	public MarcaNotFoundException(String message) {
		super(message);
	}

}
