package br.com.navita.patrimonioempresa.view;

public class PatrimonioView {

	private final String nome;
	private final String numeroDoTombo;
	private final String descricao;
	private final MarcaView marca;

	public PatrimonioView(String nome, String numeroDoTombo, String descricao, MarcaView marca) {
		this.nome = nome;
		this.numeroDoTombo = numeroDoTombo;
		this.descricao = descricao;
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroDoTombo() {
		return numeroDoTombo;
	}

	public String getDescricao() {
		return descricao;
	}

	public MarcaView getMarca() {
		return marca;
	}
	
	

}
