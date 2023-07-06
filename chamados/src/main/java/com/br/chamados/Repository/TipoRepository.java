package com.br.chamados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chamados.Model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo , Integer> {
    
}
