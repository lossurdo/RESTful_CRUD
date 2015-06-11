package com.senac.bd;

import com.senac.bean.Produto;
import com.senac.crud.CrudGenerico;
import java.util.List;

public class ProdutoBD implements CrudGenerico<Produto> {

    @Override
    public Produto consultar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto consultarPK(String pk) {
        Produto p = new Produto("100", "Teste de Produto", 1500.25);
        return p;
    }

    @Override
    public void excluir(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> listar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto salvar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> todos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
