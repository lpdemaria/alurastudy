package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olaMundoSpring")
	public String helloWord() {
		System.out.println("uma mensagem qualquer na tela");
		return "hello";
	}
	
}
