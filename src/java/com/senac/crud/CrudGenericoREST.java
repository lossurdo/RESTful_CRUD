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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * Utilizado para expor os serviços REST com base nas RNs do projeto.
 *
 * @see http://www.restapitutorial.com/lessons/httpmethods.html
 * http://gc.blog.br/2007/07/02/post-vs-put-quem-insere-e-quem-altera/
 * @author lossurdo
 * @param <T>
 */
public abstract class CrudGenericoREST<T> {

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    @GET
    @Path("{pk}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract Response consultarPK(@PathParam(value = "pk") String pk);

    @GET
    @Path("/search/{json}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract Response pesquisar(@PathParam(value = "json") String json);

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract Response listar(@QueryParam("offset") Integer offset, 
            @QueryParam("limit") Integer limit);

    @DELETE
    @Path("{pk}")
    public abstract Response excluirPK(@PathParam(value = "pk") String pk);

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public abstract Response salvar(T obj);

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response alterar(T obj) {
        return salvar(obj);
    }

    protected Response gerarResponse(T obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(obj).build();
        }
    }
    
    protected Response gerarResponse(boolean ok) {
        if (ok) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public abstract Response gerarResponse(List<T> obj);
    
    // ---------------------------------------------------------------
    // EXEMPLO DE AUTENTICAÇÃO (A IMPLEMENTAR)
    @GET
    @Path("/teste")
    public Response teste() {
        validaPermissao();
        return Response.ok().build();
    }

    private void validaPermissao() {
        if (headers.getHeaderString("senha") == null || !"teste".equals(headers.getHeaderString("senha"))) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
