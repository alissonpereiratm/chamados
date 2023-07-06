package com.br.chamados.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Chamado;
import com.br.chamados.Repository.ChamadoRepository;
import com.br.chamados.Repository.FilaRepository;

@Controller
public class FilaController {
    @Autowired
    ChamadoRepository chamadoRepository;
    @Autowired
    FilaRepository filaRepository;

    @GetMapping("/cadastroFila")
    public ModelAndView cadastroFila() {
        ModelAndView mv = new ModelAndView("cadastroFila");
        return mv;
    }

}
