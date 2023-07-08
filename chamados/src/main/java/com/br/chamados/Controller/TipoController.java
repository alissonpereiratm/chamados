package com.br.chamados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TipoController {
    

      @GetMapping("/cadastroTipoUsuario")
    public ModelAndView cadastroTipoUsuario() {
        ModelAndView mv = new ModelAndView("cadastroTipoUsuario");
        return mv;
    }
}
