package com.senac.rn;

import com.senac.bd.ProdutoBD;
import com.senac.bean.Produto;
import com.senac.crud.CrudGenericoRest;
import java.util.List;
import javax.ws.rs.Path;

@Path("/produto")
public class ProdutoRN extends CrudGenericoRest<Produto> {

    private ProdutoBD produtoBD;
    
    public ProdutoRN() {
        produtoBD = new ProdutoBD();
    }

    @Override
    public Produto consultar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto consultarPK(String pk) {
        return produtoBD.consultarPK(pk);
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
    
}
