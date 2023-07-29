package com.br.chamados.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Tipo;
import com.br.chamados.Model.Usuario;
import com.br.chamados.Repository.TipoRepository;
import com.br.chamados.Repository.UsuarioRepository;

import session.SessaoSistema;

@Controller
public class UsuarioController {
	 @Autowired
	 TipoRepository tipoRepository;
	 @Autowired
	 UsuarioRepository usuarioRepository;

	@GetMapping("/cadastroUsuario")
	public ModelAndView cadastroUsuario() {
		ModelAndView mv = new ModelAndView("cadastroUsuario");
		ArrayList<Tipo> tipoUsuarioList = (ArrayList<Tipo>) tipoRepository.findAll();
		mv.addObject("tipoUsuarios", tipoUsuarioList);
		return mv;
	}
	
    @PostMapping("/cadastroUsuario")
    public String cadastro(Usuario usuario, @RequestParam(value = "tipos", required = false) List<Integer> idTipoList) {
    	usuarioRepository.save(usuario);
    	return "redirect:/home";
    }
    
    @GetMapping("/login")
    public String loginUsuario() {
        return "login";
    }

	@PostMapping("/verificaLogin")
	public String verificar(Usuario usuario) {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioRepository.findAll(Example.of(usuario));
		if (usuarios.isEmpty()) {
			return "redirect:/login";
		}
		SessaoSistema.getInstance().setUsuarioLogado(usuarios.get(0));
		return "redirect:/home";
	}

}
