package br.com.navita.patrimonioempresa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.navita.patrimonioempresa.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String>{
	
	Optional<UserModel> findByEmail(String email);

}
