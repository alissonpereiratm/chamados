package com.br.chamados.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Chamado;
import com.br.chamados.Model.Fila;
import com.br.chamados.Model.Tipo;
import com.br.chamados.Repository.ChamadoRepository;
import com.br.chamados.Repository.FilaRepository;

import session.SessaoSistema;

@Controller
public class FilaController {
    @Autowired
    FilaRepository filaRepository;
        @Autowired
    ChamadoRepository chamadoRepository;



    @GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		ArrayList<Fila>filas = (ArrayList<Fila>) filaRepository.findAll();

		mv.addObject("filas", filas);
        mv.addObject("usuario",SessaoSistema.getInstance().getUsuarioLogado());
		return mv;
	}

    @GetMapping("/cadastroFila")
    public ModelAndView cadastroFila() {
        ModelAndView mv = new ModelAndView("cadastroFila");
        return mv;
    }

    @PostMapping("/cadastroFila")
    public String cadastro(Fila fila) {
    	filaRepository.save(fila);
    	return "redirect:/home";
    }

   

}
