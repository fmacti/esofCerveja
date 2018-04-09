package com.aula.esofcerveja.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aula.esofcerveja.model.Cerveja;

@Controller
@RequestMapping(value = "/cervejas")
public class CervejasController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja) {
		System.out.println(">>> sku: " + cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}
	
	
	
	
	
	//3.7 Aula de Validacao depois excluir o metodo de cima
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(">>>> tem erro sim!");
		}
		
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
	
	
	
	
	
	// 3.8. Forward e Redirect
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro no formulário");
			return "cerveja/CadastroCerveja";
		}
		
		// Salvar no banco de dados...
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cervejas/novo";
	}
	
}