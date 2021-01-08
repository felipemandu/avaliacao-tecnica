package br.com.navita.patrimonioempresa.dto;

import javax.validation.constraints.NotBlank;

public class MarcaDto {
	
	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
