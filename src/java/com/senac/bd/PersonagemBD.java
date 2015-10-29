package com.senac.bd;

import com.senac.bean.Personagem;
import com.senac.crud.CrudGenerico;
import com.senac.fake.BancoDadosPersonagem;
import java.util.List;

public class PersonagemBD implements CrudGenerico<Personagem> {

    @Override
    public Personagem consultar(Personagem obj) {
        return BancoDadosPersonagem.getInstance().consultar(obj);
    }

    @Override
    public boolean excluir(Personagem obj) {
        return BancoDadosPersonagem.getInstance().excluir(obj);
    }

    @Override
    public Personagem salvar(Personagem obj) {
        return BancoDadosPersonagem.getInstance().salvar(obj);
    }

    @Override
    public List<Personagem> pesquisar(Personagem obj) {
        return BancoDadosPersonagem.getInstance().pesquisar(obj);
    }

}
