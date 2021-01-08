package br.com.navita.patrimonioempresa.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Marca {

	@Id
	private UUID marcaId;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaId")
	private List<Patrimonio> patrimonio;

	public Marca() {
		marcaId = UUID.randomUUID();
	}

	public UUID getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(UUID marcaId) {
		this.marcaId = marcaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public void addPatrimonio(Patrimonio patrimonio) {
		getPatrimonio().add(patrimonio);
	}

	public List<Patrimonio> getPatrimonio() {
		return patrimonio;
	}

}
