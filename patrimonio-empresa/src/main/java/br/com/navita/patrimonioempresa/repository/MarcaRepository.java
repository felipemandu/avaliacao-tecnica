package br.com.navita.patrimonioempresa.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.navita.patrimonioempresa.model.Marca;

@Repository
public interface MarcaRepository extends PagingAndSortingRepository<Marca, UUID>{

	Optional<Marca> findByNome(String nome);

}
