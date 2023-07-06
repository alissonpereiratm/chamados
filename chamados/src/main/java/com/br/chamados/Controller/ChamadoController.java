package com.br.chamados.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Chamado;
import com.br.chamados.Model.Fila;
import com.br.chamados.Model.Produto;
import com.br.chamados.Model.Usuario;
import com.br.chamados.Repository.ChamadoRepository;
import com.br.chamados.Repository.FilaRepository;
import com.br.chamados.Repository.ProdutoRepository;
import com.br.chamados.Repository.UsuarioRepository;

@Controller
public class ChamadoController {

    @Autowired
    ChamadoRepository chamadoRepository;
    @Autowired
    FilaRepository filaRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/cadastroChamado")
    public ModelAndView cadastroChamado() {
        ModelAndView mv = new ModelAndView("cadastroChamado");
        ArrayList<Fila> filas = (ArrayList<Fila>) filaRepository.findAll();
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioRepository.findAll();
        ArrayList<Produto> produtos = (ArrayList<Produto>) produtoRepository.findAll();
        mv.addObject("filas", filas);
        mv.addObject("usuarios", usuarios);
        mv.addObject("produtos", produtos);
        return mv;
    }

    @PostMapping("/cadastroChamado")
    public String cadastro(Chamado chamado, @RequestParam(value = "usuarios", required = false) Integer usuarioId,
            @RequestParam(value = "filas", required = false) Integer filaId,
            @RequestParam(value = "produtos", required = false) Integer produtoId) {

        if (usuarioId != null && filaId != null && produtoId != null) {
            chamado.setUsuario(usuarioRepository.findById(usuarioId).get());
            chamado.setFila(filaRepository.findById(filaId).get());
            chamado.setProduto(produtoRepository.findById(produtoId).get());
            chamado.setStatus(true);
        }
        chamadoRepository.save(chamado);

        return "redirect :/cadastroChamada";
    }

}
