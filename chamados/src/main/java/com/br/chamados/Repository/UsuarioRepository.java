package com.br.chamados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.chamados.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{
    
}
