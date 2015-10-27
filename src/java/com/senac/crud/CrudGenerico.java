package com.senac.crud;

import java.util.List;

/**
 * Utilizado pelas regras de negócio (RN) e
 * classes BD.
 * @author lossurdo
 * @param <T> 
 */
public interface CrudGenerico<T> {

    T consultar(T obj);

    boolean excluir(T obj);
    
    List<T> pesquisar(T obj);

    T salvar(T obj);
    
}
