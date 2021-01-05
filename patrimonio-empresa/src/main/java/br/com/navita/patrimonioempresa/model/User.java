package br.com.navita.patrimonioempresa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String email;
	private String nome;
	private String senha;
	private Boolean enabled;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return getSenha();
	}

	public void setPassword(String password) {
		setSenha(password);
	}
	
	public String getUsername() {
		return getEmail();
	}

	public void setUsername(String username) {
		setEmail(username);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
