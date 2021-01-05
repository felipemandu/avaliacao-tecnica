package br.com.navita.patrimonioempresa.dto;

import javax.validation.constraints.NotBlank;

import br.com.navita.patrimonioempresa.model.UserModel;
import br.com.navita.patrimonioempresa.view.UserView;

public class UserDto {

	@NotBlank
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

	public UserModel toUser() {
		UserModel user = new UserModel();
		user.setEmail(email);
		user.setNome(nome);
		user.setSenha(senha);
		user.setEnabled(true);
		return user;
	}

	public UserView toUserView() {
		UserView userView = new UserView();
		userView.setEmail(email);
		userView.setNome(nome);
		return userView;
	}

}
