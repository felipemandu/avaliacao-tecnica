package br.com.navita.patrimonioempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableCaching
@EnableAuthorizationServer
public class PatrimonioEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatrimonioEmpresaApplication.class, args);
	}

	


}
