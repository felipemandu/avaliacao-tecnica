package br.com.navita.patrimonioempresa.dto;

import javax.validation.constraints.NotBlank;

public class PatrimonioDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String marcaId;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(String marcaId) {
		this.marcaId = marcaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descrição) {
		this.descricao = descrição;
	}
	
	

}
