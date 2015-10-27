package com.senac.rest;

import com.google.gson.Gson;
import com.senac.bean.Cliente;
import com.senac.crud.CrudGenericoREST;
import com.senac.rn.ClienteRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/cliente")
public class ClienteRest extends CrudGenericoREST<Cliente> {

    private final ClienteRN clienteRN;

    public ClienteRest() {
        this.clienteRN = new ClienteRN();
    }

    @Override
    public Response consultarPK(String pk) {
        Cliente cli = clienteRN.consultar(new Cliente(Integer.parseInt(pk)));
        return gerarResponse(cli);
    }

    @Override
    public Response excluirPK(String pk) {
        boolean ret = clienteRN.excluir(new Cliente(Integer.parseInt(pk)));
        return gerarResponse(ret);
    }

    @Override
    public Response salvar(Cliente obj) {
        Cliente cli = clienteRN.salvar(obj);
        URI uri = uriInfo.getAbsolutePathBuilder().path(cli.getCodigo().toString()).build();
        return Response.created(uri).build();        
    }

    @Override
    public Response pesquisar(String json) {
        Gson g = new Gson();
        Cliente cliente = g.fromJson(json, Cliente.class);
        
        List<Cliente> ret = clienteRN.pesquisar(cliente);
        
        return gerarResponse(ret);
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        List<Cliente> ret = clienteRN.pesquisar(null);
        
        return gerarResponse(ret);
    }

    @Override
    public Response gerarResponse(List<Cliente> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Cliente>> lista = new GenericEntity<List<Cliente>>(obj) {
        };
        return Response.ok(lista).build();
    }

}
