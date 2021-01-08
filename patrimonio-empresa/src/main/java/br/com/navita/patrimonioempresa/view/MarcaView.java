package br.com.navita.patrimonioempresa.view;

public class MarcaView {

	private final String nome;
	private final String id;
	
	public MarcaView(String nome, String id) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getId() {
		return id;
	}

}
