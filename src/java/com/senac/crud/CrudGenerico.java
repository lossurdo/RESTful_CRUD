package com.senac.crud;

import java.util.List;

public interface CrudGenerico<T> {

    T consultar(T obj);

    T consultarPK(String pk);

    void excluir(T obj);

    List<T> listar(T obj);

    T salvar(T obj);

    List<T> todos();
    
}
