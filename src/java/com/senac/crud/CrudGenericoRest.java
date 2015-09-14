package com.senac.crud;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
public abstract class CrudGenericoRest<T> implements CrudGenerico<T> {

    /* **************************************************
        MÉTODOS para utilização no serviço REST
    */    
    @GET
    @Path(value = "{pk}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract T consultarPK(@PathParam(value = "pk") String pk);

    @DELETE
    @Path(value = "/excluir/{pk}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public abstract void excluirPK(@PathParam(value = "pk") String pk);
    

    /* **************************************************
        MÉTODOS para utilização no serviço REST
        PADRÃO para as outras chamadas do CRUD
    */
    @GET
    @Path(value = "/pesquisar")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract List<T> pesquisar(T obj);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> listarTodos() {
        return pesquisar(null);
    }

    @POST
    @Path(value = "/salvar")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Override
    public abstract T salvar(T obj);
    
}
