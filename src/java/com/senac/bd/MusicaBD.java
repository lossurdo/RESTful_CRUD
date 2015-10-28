package com.senac.bd;

import com.senac.bean.Musica;
import com.senac.crud.CrudGenerico;
import com.senac.fake.BancoDadosMusica;
import java.util.List;

public class MusicaBD implements CrudGenerico<Musica> {

    @Override
    public Musica consultar(Musica obj) {
        return BancoDadosMusica.getInstance().consultar(obj);
    }

    @Override
    public boolean excluir(Musica obj) {
        return BancoDadosMusica.getInstance().excluir(obj);
    }

    @Override
    public List<Musica> pesquisar(Musica obj) {
        return BancoDadosMusica.getInstance().pesquisar(obj);
    }

    @Override
    public Musica salvar(Musica obj) {
        return BancoDadosMusica.getInstance().salvar(obj);
    }
    
}
