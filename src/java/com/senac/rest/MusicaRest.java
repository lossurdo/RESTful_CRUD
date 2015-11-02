package com.senac.rest;

import com.google.gson.Gson;
import com.senac.bean.Musica;
import com.senac.crud.CrudGenericoRest;
import com.senac.infra.RNException;
import com.senac.rn.MusicaRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/musicas")
public class MusicaRest extends CrudGenericoRest<Musica> {
    private final MusicaRN musicaRN;

    public MusicaRest() {
        this.musicaRN = new MusicaRN();
    }

    @Override
    public Response consultarPK(String pk) {
        try {
            Musica m = musicaRN.consultar(new Musica(Integer.parseInt(pk)));
            return Response.ok(m).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Musica m = g.fromJson(json, Musica.class);

            List<Musica> ret = musicaRN.pesquisar(m);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Musica> ret = musicaRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            musicaRN.excluir(new Musica(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Musica obj) {
        try {
            Musica m = musicaRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(m.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response gerarResponseParaCollection(List<Musica> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Musica>> lista = new GenericEntity<List<Musica>>(obj) {
        };
        return Response.ok(lista).build();    
    }
    
}
