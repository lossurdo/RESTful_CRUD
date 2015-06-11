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
    public List<Cliente> listar(Cliente obj) {
        return clienteBD.listar(obj);
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
        return clienteBD.consultarPK(pk);
    }

    @Override
    public void excluir(Cliente obj) {
        clienteBD.excluir(obj);
    }

}
