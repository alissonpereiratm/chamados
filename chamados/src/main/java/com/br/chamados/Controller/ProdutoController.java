package com.br.chamados.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Chamado;
import com.br.chamados.Model.Produto;
import com.br.chamados.Repository.ChamadoRepository;
import com.br.chamados.Repository.ProdutoRepository;

public class ProdutoController {

    @Autowired
    ChamadoRepository chamadoRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastroProduto() {
        ModelAndView mv = new ModelAndView("cadastroProduto");
        return mv;
    }

}
