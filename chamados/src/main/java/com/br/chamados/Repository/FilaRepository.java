package com.br.chamados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chamados.Model.Fila;

public interface FilaRepository extends JpaRepository<Fila , Integer>{
    
}
