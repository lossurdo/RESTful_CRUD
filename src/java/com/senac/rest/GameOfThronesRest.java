package com.senac.rest;

import com.google.gson.Gson;
import com.senac.bean.GameOfThrones;
import com.senac.crud.CrudGenericoREST;
import com.senac.rn.GameOfThronesRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/got")
public class GameOfThronesRest extends CrudGenericoREST<GameOfThrones> {

    private final GameOfThronesRN gotRN;

    public GameOfThronesRest() {
        this.gotRN = new GameOfThronesRN();
    }

    @Override
    public Response consultarPK(String pk) {
        GameOfThrones cli = gotRN.consultar(new GameOfThrones(Integer.parseInt(pk)));
        return gerarResponse(cli);
    }

    @Override
    public Response excluirPK(String pk) {
        boolean ret = gotRN.excluir(new GameOfThrones(Integer.parseInt(pk)));
        return gerarResponse(ret);
    }

    @Override
    public Response salvar(GameOfThrones obj) {
        GameOfThrones cli = gotRN.salvar(obj);
        URI uri = uriInfo.getAbsolutePathBuilder().path(cli.getCodigo().toString()).build();
        return Response.created(uri).build();        
    }

    @Override
    public Response pesquisar(String json) {
        Gson g = new Gson();
        GameOfThrones cliente = g.fromJson(json, GameOfThrones.class);
        
        List<GameOfThrones> ret = gotRN.pesquisar(cliente);
        
        return gerarResponse(ret);
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        List<GameOfThrones> ret = gotRN.pesquisar(null);
        
        return gerarResponse(ret);
    }

    @Override
    public Response gerarResponse(List<GameOfThrones> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<GameOfThrones>> lista = new GenericEntity<List<GameOfThrones>>(obj) {
        };
        return Response.ok(lista).build();
    }

}
