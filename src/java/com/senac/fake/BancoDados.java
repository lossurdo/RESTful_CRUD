package com.senac.fake;

import com.senac.bean.Cliente;
import com.senac.crud.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BancoDados implements CrudGenerico<Cliente> {

    private TreeSet<Cliente> listaCliente;

    private BancoDados() {
        listaCliente = new TreeSet<>();
        
        // dados fake        
        listaCliente.add(new Cliente(100, "Robert Baratheon"));
        listaCliente.add(new Cliente(200, "Tyrion Lannister"));
        listaCliente.add(new Cliente(300, "Jon Snow"));
        listaCliente.add(new Cliente(400, "Arya Stark"));
        listaCliente.add(new Cliente(500, "Daenerys Targaryen"));
    }

    public static BancoDados getInstance() {
        return BancoDadosHolder.INSTANCE;
    }

    @Override
    public List<Cliente> pesquisar(Cliente obj) {
        if(obj==null) {
            return new ArrayList<>(listaCliente);
        }
        TreeSet<Cliente> lista = new TreeSet<>();
        for (Cliente c : listaCliente) {
            if (c.getCodigo().equals(obj.getCodigo())
                    || (obj.getNome()!=null && c.getNome().contains(obj.getNome()))) {
                lista.add(c);
            }
        }
        return new ArrayList<>(lista);
    }

    private static class BancoDadosHolder {

        private static final BancoDados INSTANCE = new BancoDados();
    }

    @Override
    public Cliente consultar(Cliente obj) {
        for (Cliente c : listaCliente) {
            if (c.equals(obj)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void excluir(Cliente obj) {
        listaCliente.remove(obj);
    }

    @Override
    public Cliente salvar(Cliente obj) {
        listaCliente.remove(obj);
        listaCliente.add(obj);
        return obj;
    }

}
