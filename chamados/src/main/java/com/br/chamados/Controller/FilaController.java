package com.br.chamados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Fila;
import com.br.chamados.Repository.FilaRepository;

@Controller
public class FilaController {
    @Autowired
    FilaRepository filaRepository;

    @GetMapping("/cadastroFila")
    public ModelAndView cadastroFila() {
        ModelAndView mv = new ModelAndView("cadastroFila");
        return mv;
    }

    @PostMapping("/cadastroFila")
    public String cadastro(Fila fila) {
    	filaRepository.save(fila);
    	return "redirect:/cadastroFila";
    }

}
