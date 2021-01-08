package br.com.navita.patrimonioempresa.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patrimonio {

	@Id
	private UUID numeroDoTombo;

	private String nome;

	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marcaId;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	public Patrimonio() {
		numeroDoTombo = UUID.randomUUID();
	}

	public UUID getNumeroDoTombo() {
		return numeroDoTombo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarcaId() {
		return marcaId;
	}

	public Marca getMarca() {
		return marcaId;
	}

	public void setMarcaId(Marca marcaId) {
		this.marcaId = marcaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
