package com.senac.crud;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * 
 * GET -> SELECT
 * DELETE -> DELETE
 * POST -> INSERT
 * PUT -> UPDATE
 * 
 * @see http://www.restapitutorial.com/lessons/httpmethods.html e
 *  http://gc.blog.br/2007/07/02/post-vs-put-quem-insere-e-quem-altera/
 * @author lossurdo
 * @param <T> 
 */
public abstract class CrudGenericoREST<T> implements CrudGenerico<T> {

    @Context
    protected UriInfo uriInfo;
    
    @Context 
    protected HttpHeaders headers;
    
    @GET
    @Path("{pk}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract T consultarPK(@PathParam(value = "pk") String pk);

    @GET
    @Path("/search/{json}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract List<T> pesquisar(@PathParam(value = "json") String json);

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract List<T> pesquisar(T obj);
    
    @DELETE
    @Path("{pk}")
    public abstract void excluirPK(@PathParam(value = "pk") String pk);
    
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract T salvar(T obj);
    
    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public T alterar(T obj) {
        return salvar(obj);
    }
        
    @GET
    @Path("/teste")
    public Response teste() {
        validaPermissao();
        return Response.ok().build();
    }
    
    private void validaPermissao() {
        if(headers.getHeaderString("senha")==null || !"teste".equals(headers.getHeaderString("senha"))) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
