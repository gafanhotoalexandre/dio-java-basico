package dio.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
* Projeto SpringBoot gerado via Spring Initializr.
* Os seguintes módulos foram selecionados:
* - Spring Data JPA
* - Spring Web
* - H2 Database
* - OpenFeign
*
* @author gafanhotoalexandre
* */
@EnableFeignClients
@SpringBootApplication
public class GofApplication {

	public static void main(String[] args) {
		SpringApplication.run(GofApplication.class, args);
	}

}
