package com.senac.bd;

import com.senac.bean.Cliente;
import com.senac.crud.CrudGenerico;
import com.senac.fake.BancoDados;
import java.util.List;

public class ClienteBD implements CrudGenerico<Cliente> {

    @Override
    public Cliente consultar(Cliente obj) {
        return BancoDados.getInstance().consultar(obj);
    }

    @Override
    public void excluir(Cliente obj) {
        BancoDados.getInstance().excluir(obj);
    }

    @Override
    public Cliente salvar(Cliente obj) {
        return BancoDados.getInstance().salvar(obj);
    }

    @Override
    public List<Cliente> pesquisar(Cliente obj) {
        return BancoDados.getInstance().pesquisar(obj);
    }

}
