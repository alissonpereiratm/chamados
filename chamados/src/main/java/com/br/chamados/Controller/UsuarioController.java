package com.br.chamados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

      @GetMapping("/cadastroUsuario")
    public ModelAndView cadastroUsuario() {
        ModelAndView mv = new ModelAndView("cadastroUsuario");
        return mv;
    }
    
}
