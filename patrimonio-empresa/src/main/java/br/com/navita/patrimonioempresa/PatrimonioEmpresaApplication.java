package br.com.navita.patrimonioempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@EnableCaching
public class PatrimonioEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatrimonioEmpresaApplication.class, args);
	}

	@Bean
	public OpenAPI springDocOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Patrimonio Empresa")
				.description("Web Api Rest para o gerenciamenento de um empresa")
				.version("v0.0.1"));
	}

}
