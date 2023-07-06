package com.br.chamados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chamados.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto , Integer> {
    
}
