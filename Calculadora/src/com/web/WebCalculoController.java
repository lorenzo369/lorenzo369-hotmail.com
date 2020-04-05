package com.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebCalculoController {
	@Autowired
	protected WebSumaService sumaService;

	@Autowired
	protected WebRestaService restaService;

	protected Logger logger = Logger.getLogger(WebCalculoController.class
			.getName());

	public WebCalculoController(WebSumaService sumaService, WebRestaService restaService) {
		this.sumaService = sumaService;
		this.restaService = restaService;
	}

	@RequestMapping("/suma")
	public String doSuma(@RequestParam(defaultValue="0") String operando1,
			@RequestParam(defaultValue="0") String operando2,
			Model model) {

		String suma = sumaService.sumar(operando1, operando2);

		logger.info("Suma: " + suma);
		model.addAttribute("json", suma);

		return "suma";
	}

	@RequestMapping("/resta")
	public String doResta(@RequestParam(defaultValue="0") String restador1,
			@RequestParam(defaultValue="0") String restador2,
			Model modelo) {

		String resultado = restaService.restar(restador1, restador2);

		logger.info("Resultado: " + resultado);
		modelo.addAttribute("json", resultado);

		return "resultado";
	}
}