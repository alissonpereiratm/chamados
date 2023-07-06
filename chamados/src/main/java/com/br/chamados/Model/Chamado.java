package com.br.chamados.Model;





import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
   private  LocalDate data;
  

    private String titulo;
    private String descricao;
    private String historico;
    private boolean status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fila fila;
    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public Chamado() {

    }

 

    

    public Chamado(int id, LocalDate data, String titulo, String descricao, String historico, boolean status, Fila fila,
            Produto produto, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.descricao = descricao;
        this.historico = historico;
        this.status = status;
        this.fila = fila;
        this.produto = produto;
        this.usuario = usuario;
    }



  public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
