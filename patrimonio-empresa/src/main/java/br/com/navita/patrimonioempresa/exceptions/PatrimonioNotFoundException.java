package br.com.navita.patrimonioempresa.exceptions;

@SuppressWarnings("serial")
public class PatrimonioNotFoundException extends RuntimeException {

	public PatrimonioNotFoundException(String message) {
		super(message);
	}

}
