package com.br.chamados.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.chamados.Model.Produto;
import com.br.chamados.Repository.ProdutoRepository;

@Controller
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/cadastroProduto")
    public ModelAndView cadastroProduto() {
        ModelAndView mv = new ModelAndView("cadastroProduto");
        return mv;
    }
    
    @PostMapping("/cadastroProduto")
	public String cadastro(Produto produto) {
    	produtoRepository.save(produto);
        return "redirect:/cadastroProduto";
    }

}
