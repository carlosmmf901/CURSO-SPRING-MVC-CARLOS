package com.gereciamentoEstoque.gerenciamentoEstoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gereciamentoEstoque.gerenciamentoEstoque", "configuration"})

public class GerenciamentoEstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoEstoqueApplication.class, args);
	}

}
