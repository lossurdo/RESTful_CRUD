package com.senac.crud;

import java.util.List;

public interface CrudGenerico<T> {

    T consultar(T obj);

    void excluir(T obj);
    
    List<T> pesquisar(T obj);

    T salvar(T obj);
    
}
