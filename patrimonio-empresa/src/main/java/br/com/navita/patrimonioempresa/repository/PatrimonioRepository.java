package br.com.navita.patrimonioempresa.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.navita.patrimonioempresa.model.Patrimonio;

@Repository
public interface PatrimonioRepository extends PagingAndSortingRepository<Patrimonio, UUID> {
	
	@Query("select p from Patrimonio p join p.marcaId m where m.nome = :nome")
	Page<Patrimonio> findByMarcaNome(@Param("nome") String nome, Pageable page);

	@Query("select p from Patrimonio p join p.marcaId m where m.marcaId = :id")
	Page<Patrimonio> findByMarcaId(@Param("id") UUID id, Pageable page);

	@Query("select p from Patrimonio p join p.marcaId m where m.nome LIKE %:nome%")
	Page<Patrimonio> findByMarcaNomeLike(@Param("nome") String nome, Pageable page);

	@Query("select p from Patrimonio p where p.descricao LIKE %:descricao%")
	Page<Patrimonio> findByDescricaoLike(@Param("descricao") String descricao, Pageable page);
	

}
