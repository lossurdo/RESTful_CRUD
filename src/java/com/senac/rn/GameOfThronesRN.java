package com.senac.rn;

import com.senac.bd.GameOfThronesBD;
import com.senac.bean.GameOfThrones;
import com.senac.crud.CrudGenerico;
import java.util.List;

public class GameOfThronesRN implements CrudGenerico<GameOfThrones> {

    private GameOfThronesBD clienteBD;
    
    public GameOfThronesRN() {
        clienteBD = new GameOfThronesBD();
    }

    @Override
    public GameOfThrones salvar(GameOfThrones obj) {
        return clienteBD.salvar(obj);
    }

    @Override
    public GameOfThrones consultar(GameOfThrones obj) {
        return clienteBD.consultar(obj);
    }
    
    @Override
    public boolean excluir(GameOfThrones obj) {
        return clienteBD.excluir(obj);
    }
   
    @Override
    public List<GameOfThrones> pesquisar(GameOfThrones obj) {
        return clienteBD.pesquisar(obj);
    }
    
}
