package com.senac.rn;

import com.senac.bd.MusicaBD;
import com.senac.bean.Musica;
import com.senac.crud.CrudGenerico;
import java.util.List;

public class MusicaRN implements CrudGenerico<Musica> {
    private final MusicaBD musicaBD;

    public MusicaRN() {
        this.musicaBD = new MusicaBD();
    }

    @Override
    public Musica consultar(Musica obj) {
        return musicaBD.consultar(obj);
    }

    @Override
    public boolean excluir(Musica obj) {
        return musicaBD.excluir(obj);
    }

    @Override
    public List<Musica> pesquisar(Musica obj) {
        return musicaBD.pesquisar(obj);
    }

    @Override
    public Musica salvar(Musica obj) {
        return musicaBD.salvar(obj);
    }
    
}
