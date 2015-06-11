package com.senac.rn;

import com.senac.bean.Cliente;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import javax.ws.rs.core.MediaType;
import org.junit.*;

public class ClienteRNTest {

    Client client = null;

    @Before
    public void setUp() {
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
    }

    @Test
    public void testTodosViaJEE() throws Exception {
        URL url = new URL("http://localhost:8080/RESTful_CRUD/rest/cliente/todos");
        URLConnection conn = url.openConnection();
        JsonReader jr = Json.createReader(conn.getInputStream());        
        System.out.println(jr.readArray().toString());
    }
    
    @Test
    public void testTodos() {
        WebResource resource = client.resource("http://localhost:8080/RESTful_CRUD/rest/cliente/todos");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        String json = response.getEntity(String.class);
        Assert.assertNotNull(json);
    }

    @Test
    public void testSalvar() {
        WebResource resource = client.resource("http://localhost:8080/RESTful_CRUD/rest/cliente/salvar");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, new Cliente(999, "Novo Cliente"));
        Cliente cliente = response.getEntity(Cliente.class);
        Assert.assertEquals(cliente.getCodigo(), Integer.valueOf(999));
    }

    @Test
    public void testExcluir() {
        WebResource resource = client.resource("http://localhost:8080/RESTful_CRUD/rest/cliente/excluir");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, new Cliente(100));
    }

}
