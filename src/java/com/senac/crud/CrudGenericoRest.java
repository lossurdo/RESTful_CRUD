package com.senac.crud;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

public abstract class CrudGenericoRest<T> implements CrudGenerico<T> {

    @Context
    private UriInfo uriInfo;

    @POST
    @Path(value = "/consultar")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract T consultar(T obj);

    @GET
    @Path(value = "{pk}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract T consultarPK(@PathParam(value = "pk") String pk);

    @POST
    @Path(value = "/excluir")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract void excluir(T obj);

    @POST
    @Path(value = "/listar")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract List<T> listar(T obj);

    @POST
    @Path(value = "/salvar")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract T salvar(T obj);

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public List<T> todos() {
        return listar(null);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/info")
    public String info() {
        return "{\"resultado\":\"ok\", "
                + "\"uri\":\"" + uriInfo.getRequestUri().toASCIIString() + "\"}";
    }

    public UriInfo getUriInfo() {
        return uriInfo;
    }

}
