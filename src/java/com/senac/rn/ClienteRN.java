package com.senac.rn;

import com.google.gson.Gson;
import com.senac.bd.ClienteBD;
import com.senac.bean.Cliente;
import com.senac.crud.CrudGenericoREST;
import java.util.List;
import javax.ws.rs.Path;

@Path("/cliente")
public class ClienteRN extends CrudGenericoREST<Cliente> {

    private ClienteBD clienteBD;
    
    public ClienteRN() {
        clienteBD = new ClienteBD();
    }

    @Override
    public Cliente salvar(Cliente obj) {
        System.out.println("salvar: " + obj);
        return clienteBD.salvar(obj);
    }

    @Override
    public Cliente consultar(Cliente obj) {
        System.out.println("consultar: " + obj);
        return clienteBD.consultar(obj);
    }
    
    @Override
    public void excluir(Cliente obj) {
        System.out.println("excluir: " + obj);
        clienteBD.excluir(obj);
    }
   
    @Override
    public Cliente consultarPK(String pk) {
        System.out.println("consultarPK: " + pk);
        return clienteBD.consultar(new Cliente(Integer.parseInt(pk)));
    }

    @Override
    public void excluirPK(String pk) {
        System.out.println("excluirPK: " + pk);
        clienteBD.excluir(new Cliente(Integer.parseInt(pk)));
    }

    @Override
    public List<Cliente> pesquisar(Cliente obj) {
        System.out.println("pesquisar: " + obj);
        return clienteBD.pesquisar(obj);
    }

    @Override
    public List<Cliente> pesquisar(String json) {
        System.out.println("pesquisar: " + json);
        Gson g = new Gson();
        Cliente cliente = g.fromJson(json, Cliente.class);
        System.out.println("pesquisar: " + cliente);
        return clienteBD.pesquisar(cliente);
    }
    
}
