package com.senac.bd;

import com.senac.bean.GameOfThrones;
import com.senac.crud.CrudGenerico;
import com.senac.fake.BancoDados;
import java.util.List;

public class GameOfThronesBD implements CrudGenerico<GameOfThrones> {

    @Override
    public GameOfThrones consultar(GameOfThrones obj) {
        return BancoDados.getInstance().consultar(obj);
    }

    @Override
    public boolean excluir(GameOfThrones obj) {
        return BancoDados.getInstance().excluir(obj);
    }

    @Override
    public GameOfThrones salvar(GameOfThrones obj) {
        return BancoDados.getInstance().salvar(obj);
    }

    @Override
    public List<GameOfThrones> pesquisar(GameOfThrones obj) {
        return BancoDados.getInstance().pesquisar(obj);
    }

}
