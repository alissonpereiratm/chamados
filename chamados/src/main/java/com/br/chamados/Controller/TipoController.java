package com.br.chamados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Tipo;
import com.br.chamados.Repository.TipoRepository;

@Controller
public class TipoController {
	@Autowired
    TipoRepository tipoRepository;
    

	@GetMapping("/cadastroTipoUsuario")
	public ModelAndView cadastroTipoUsuario() {
		ModelAndView mv = new ModelAndView("cadastroTipoUsuario");
		return mv;
	}
	
	 @PostMapping("/cadastroTipoUsuario")
    public String cadastro(Tipo Tipo) {
    	tipoRepository.save(Tipo);
    	return "redirect:/home";
    }
}
