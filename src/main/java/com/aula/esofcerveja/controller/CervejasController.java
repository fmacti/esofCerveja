package com.aula.esofcerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cervejas")
public class CervejasController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
}