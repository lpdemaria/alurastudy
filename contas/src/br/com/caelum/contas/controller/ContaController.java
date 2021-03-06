package br.com.caelum.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/form")
	public String contaForm() {
		return "conta/formulario";
	}

	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		
		// se tiver erro, redirecione para o formulário
	    if(result.hasErrors()) {
	      return "conta/formulario";
	    }
		
		ContaDAO dao = getContaDAO();
		dao.adiciona(conta);
		return "conta/conta-adicionada";
	}

	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		ContaDAO dao = getContaDAO();
		dao.remove(conta);
		return "redirect:listaContas";
	}

	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
		ContaDAO dao = getContaDAO();
		model.addAttribute("conta", dao.buscaPorId(id));
		return "conta/mostra";
	}

	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		ContaDAO dao = getContaDAO();
		dao.altera(conta);
		return "redirect:listaContas";
	}

	private ContaDAO getContaDAO() {
		ContaDAO dao = new ContaDAO();
		return dao;
	}

	@RequestMapping("/listaContas")
	public String lista(Model mv) {
		ContaDAO dao = getContaDAO();
		List<Conta> contas = dao.lista();

		mv.addAttribute("contas", contas);
		return "conta/lista";
	}
}
