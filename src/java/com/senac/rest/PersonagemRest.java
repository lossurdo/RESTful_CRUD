package com.senac.rest;

import com.google.gson.Gson;
import com.senac.bean.Personagem;
import com.senac.crud.CrudGenericoRest;
import com.senac.infra.RNException;
import com.senac.rn.PersonagemRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Path("/personagens")
public class PersonagemRest extends CrudGenericoRest<Personagem> {

    private final PersonagemRN personagemRN;

    public PersonagemRest() {
        this.personagemRN = new PersonagemRN();
    }

    @Override
    public Response consultarPK(String pk) {
        try {
            Personagem p = personagemRN.consultar(new Personagem(Integer.parseInt(pk)));
            return Response.ok(p).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {        
        try {
            personagemRN.excluir(new Personagem(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Personagem obj) {
        try {
            Personagem p = personagemRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(p.getCodigo().toString()).build();
            return Response.created(uri).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Personagem p = g.fromJson(json, Personagem.class);

            List<Personagem> ret = personagemRN.pesquisar(p);

            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Personagem> ret = personagemRN.pesquisar(null);

            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response gerarResponseParaCollection(List<Personagem> obj) {
        if (obj == null || obj.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        GenericEntity<List<Personagem>> lista = new GenericEntity<List<Personagem>>(obj) {
        };
        return Response.ok(lista).build();
    }

}
