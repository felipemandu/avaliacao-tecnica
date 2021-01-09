package br.com.navita.patrimonioempresa.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {

	@Email
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
