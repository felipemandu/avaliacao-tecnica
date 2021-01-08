package br.com.navita.patrimonioempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PatrimonioEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatrimonioEmpresaApplication.class, args);
	}

}
