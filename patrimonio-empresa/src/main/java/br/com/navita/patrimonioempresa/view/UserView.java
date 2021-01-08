package br.com.navita.patrimonioempresa.view;

public class UserView {

	private final String email;
	private final String nome;

	public UserView(String email, String nome) {
		this.email = email;
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

}
