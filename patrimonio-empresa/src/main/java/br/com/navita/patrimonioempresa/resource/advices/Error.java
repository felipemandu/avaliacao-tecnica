package br.com.navita.patrimonioempresa.resource.advices;

class Error {
	private final String message;
	private final String nome;

	Error(String nome, String message) {
		this.nome = nome;
		this.message = message;
	}



	public String getNome() {
		return nome;
	}

	public String getMessage() {
		return message;
	}

}