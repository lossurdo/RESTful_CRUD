package com.senac.bean;

import java.io.Serializable;

public class Musica implements Serializable, Comparable<Musica> {

    private int id;
    private String artista;
    private String musica;

    public Musica() {
    }

    public Musica(int id) {
        this.id = id;
    }

    public Musica(int id, String artista, String musica) {
        this.id = id;
        this.artista = artista;
        this.musica = musica;
    }
    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
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
        final Musica other = (Musica) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Musica{" + "id=" + id + ", artista=" + artista + ", musica=" + musica + '}';
    }

    @Override
    public int compareTo(Musica o) {
        return Integer.toString(id).compareTo(Integer.toString(o.getId()));
    }
    
}
