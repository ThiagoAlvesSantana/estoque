package br.com.fiap.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "br.com.fiap.estoque.controller","br.com.fiap.estoque.service" })
@EnableJpaRepositories(basePackages = { "br.com.fiap.estoque.repository" })
@EntityScan(basePackages = { "br.com.fiap.estoque.domain" })
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

}
