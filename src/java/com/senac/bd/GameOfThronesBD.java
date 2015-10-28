package com.senac.bd;

import com.senac.bean.GameOfThrones;
import com.senac.crud.CrudGenerico;
import com.senac.fake.BancoDadosGOT;
import java.util.List;

public class GameOfThronesBD implements CrudGenerico<GameOfThrones> {

    @Override
    public GameOfThrones consultar(GameOfThrones obj) {
        return BancoDadosGOT.getInstance().consultar(obj);
    }

    @Override
    public boolean excluir(GameOfThrones obj) {
        return BancoDadosGOT.getInstance().excluir(obj);
    }

    @Override
    public GameOfThrones salvar(GameOfThrones obj) {
        return BancoDadosGOT.getInstance().salvar(obj);
    }

    @Override
    public List<GameOfThrones> pesquisar(GameOfThrones obj) {
        return BancoDadosGOT.getInstance().pesquisar(obj);
    }

}
