package com.senac.rn;

import com.senac.bd.PersonagemBD;
import com.senac.bean.Personagem;
import com.senac.crud.CrudGenericoRN;
import java.util.List;

public class PersonagemRN extends CrudGenericoRN<Personagem> {

    private PersonagemBD personagemBD;

    public PersonagemRN() {
        personagemBD = new PersonagemBD();
    }

    @Override
    public Personagem salvar(Personagem obj) {
        avaliarSalvar(personagemBD, obj);
        return personagemBD.salvar(obj);
    }

    @Override
    public Personagem consultar(Personagem obj) {
        return (Personagem) avaliarConsultar(personagemBD, obj);
    }

    @Override
    public boolean excluir(Personagem obj) {
        return avaliarExcluir(personagemBD, obj);
    }

    @Override
    public List<Personagem> pesquisar(Personagem obj) {
        return (List<Personagem>) avaliarPesquisar(personagemBD, obj);
    }

}
