package com.senac.bean;

import java.io.Serializable;
import java.util.Objects;

public class Personagem implements Serializable, Comparable<Personagem> {

    private Integer codigo;
    private String nome;
    private String descricao;

    public Personagem() {
    }

    public Personagem(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Personagem(Integer codigo) {
        this.codigo = codigo;
    }

    public Personagem(Integer codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Personagem{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personagem other = (Personagem) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Personagem personagem) {
        return personagem.getCodigo().compareTo(codigo);
    }
            
}
