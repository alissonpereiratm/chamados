package com.br.chamados.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Chamado;
import com.br.chamados.Model.Fila;
import com.br.chamados.Model.Produto;
import com.br.chamados.Model.Usuario;
import com.br.chamados.Repository.ChamadoRepository;
import com.br.chamados.Repository.FilaRepository;
import com.br.chamados.Repository.ProdutoRepository;
import com.br.chamados.Repository.UsuarioRepository;

import session.SessaoSistema;

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
        ArrayList<Produto> produtos = (ArrayList<Produto>) produtoRepository.findAll();
        mv.addObject("filas", filas);
        mv.addObject("produtos", produtos);
        return mv;
    }

    @PostMapping("/cadastroChamado")
    public String cadastro(Chamado chamado) {
        if (SessaoSistema.getInstance().isNaoPossuiUsuarioLogado()) {
            return "redirect:/login";
        }
        chamado.setUsuario(usuarioRepository.findById(SessaoSistema.getInstance().getUsuarioLogado().getId()).get());
        chamado.setData(LocalDate.now());
        chamadoRepository.save(chamado);
        return "redirect:/home";
    }

    @GetMapping("/listaChamado/{id}")
    public ModelAndView listaChamado(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("listaChamado");
        Fila fila = filaRepository.findById(id).get();
        mv.addObject("chamados", fila.getChamados());
        return mv;
    }

    @GetMapping("/chamadoDetalhado/{id}")
    public ModelAndView chamadoDetalhado(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("chamadoDetalhado");
        Chamado chamado = chamadoRepository.findById(id).get();
        mv.addObject("chamado", chamado);
        return mv;
    }

    @PostMapping("/finalizaChamado")
    public String finalizaChamado(Chamado chamado) {
      /* if (SessaoSistema.getInstance().isNaoPossuiUsuarioLogado()) {
            return "redirect:/login";
        }*/
        Chamado chamadoBanco=chamadoRepository.findById(chamado.getId()).get();
        chamadoBanco.setStatus(true);
        chamadoBanco.setHistorico(chamado.getHistorico());
        chamadoRepository.save(chamadoBanco);
        return "redirect:/home";
    }

}
