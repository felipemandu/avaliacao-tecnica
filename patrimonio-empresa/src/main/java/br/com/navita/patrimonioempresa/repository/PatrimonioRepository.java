package br.com.navita.patrimonioempresa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.navita.patrimonioempresa.model.Patrimonio;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, UUID>{

}
