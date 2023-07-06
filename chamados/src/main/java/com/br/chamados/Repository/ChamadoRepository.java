package com.br.chamados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chamados.Model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado , Integer>{
    
}
