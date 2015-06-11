package com.senac.bean;

public class Produto {

    private String codigo;
    private String nome;
    private Double preco;

    public Produto() {
    }

    public Produto(String codigo) {
        this.codigo = codigo;
    }

    public Produto(String codigo, String nome, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + '}';
    }
           
}
