package com.senac.rn;

import com.senac.bd.ClienteBD;
import com.senac.bean.Cliente;
import com.senac.crud.CrudGenerico;
import java.util.List;

public class ClienteRN implements CrudGenerico<Cliente> {

    private ClienteBD clienteBD;
    
    public ClienteRN() {
        clienteBD = new ClienteBD();
    }

    @Override
    public Cliente salvar(Cliente obj) {
        return clienteBD.salvar(obj);
    }

    @Override
    public Cliente consultar(Cliente obj) {
        return clienteBD.consultar(obj);
    }
    
    @Override
    public boolean excluir(Cliente obj) {
        return clienteBD.excluir(obj);
    }
   
    @Override
    public List<Cliente> pesquisar(Cliente obj) {
        return clienteBD.pesquisar(obj);
    }
    
}
