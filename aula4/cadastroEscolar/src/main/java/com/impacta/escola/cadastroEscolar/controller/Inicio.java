package com.impacta.escola.cadastroEscolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inicio {
	
	@GetMapping("/inicio")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/cadastroJogadorRota")//Rota
	public String cadastro() {
		
		return "cadastroJogador";//Arquivo HTML
	}

}
