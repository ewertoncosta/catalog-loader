package br.com.cvc.catalogloader.expedia.expediacatalogloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication(
		scanBasePackages = {"br.com.cvc.catalogloader"},
		exclude = {WebMvcAutoConfiguration.class}
)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
