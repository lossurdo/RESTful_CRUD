package com.senac.rest;

import com.google.gson.Gson;
import com.senac.bean.Musica;
import com.senac.crud.CrudGenericoREST;
import com.senac.rn.MusicaRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/musicas")
public class MusicaRest extends CrudGenericoREST<Musica> {
    private final MusicaRN musicaRN;

    public MusicaRest() {
        this.musicaRN = new MusicaRN();
    }

    @Override
    public Response consultarPK(String pk) {
        Musica m = musicaRN.consultar(new Musica(Integer.parseInt(pk)));
        return gerarResponse(m);
    }

    @Override
    public Response pesquisar(String json) {
        Gson g = new Gson();
        Musica m = g.fromJson(json, Musica.class);
        
        List<Musica> ret = musicaRN.pesquisar(m);
        
        return gerarResponse(ret);    
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        List<Musica> ret = musicaRN.pesquisar(null);        
        return gerarResponse(ret);
    }

    @Override
    public Response excluirPK(String pk) {
        boolean ret = musicaRN.excluir(new Musica(Integer.parseInt(pk)));
        return gerarResponse(ret);    }

    @Override
    public Response salvar(Musica obj) {
        Musica m = musicaRN.salvar(obj);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(m.getId())).build();
        return Response.created(uri).build();      
    }

    @Override
    public Response gerarResponse(List<Musica> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Musica>> lista = new GenericEntity<List<Musica>>(obj) {
        };
        return Response.ok(lista).build();    
    }
    
}
