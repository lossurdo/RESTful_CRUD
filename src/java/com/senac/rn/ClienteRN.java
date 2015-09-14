package com.senac.rn;

import com.senac.bd.ClienteBD;
import com.senac.bean.Cliente;
import com.senac.crud.CrudGenericoRest;
import java.util.List;
import javax.ws.rs.Path;

@Path("/cliente")
public class ClienteRN extends CrudGenericoRest<Cliente> {

    private ClienteBD clienteBD;
    
    public ClienteRN() {
        clienteBD = new ClienteBD();
    }

    @Override
    public List<Cliente> pesquisar(Cliente obj) {
        return clienteBD.pesquisar(obj);
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
    public Cliente consultarPK(String pk) {
        return clienteBD.consultar(new Cliente(Integer.parseInt(pk)));
    }

    @Override
    public void excluir(Cliente obj) {
        clienteBD.excluir(obj);
    }

    @Override
    public void excluirPK(String pk) {
        excluir(new Cliente(Integer.parseInt(pk)));
    }

}
