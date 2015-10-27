package com.senac.fake;

import com.senac.bean.GameOfThrones;
import com.senac.crud.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BancoDados implements CrudGenerico<GameOfThrones> {

    private TreeSet<GameOfThrones> listaGOT;

    private BancoDados() {
        listaGOT = new TreeSet<>();
        
        // dados fake        
        listaGOT.add(new GameOfThrones(100, "Petyr Baelish", "Lorde Petyr Baelish, chamado de \"Mindinho\", é o Mestre da Moeda do Pequeno Conselho. Ele cresceu com Catelyn Tully e lutou por sua mão com o irmão de Eddard Stark, Brandon Stark"));
        listaGOT.add(new GameOfThrones(200, "Joffrey Baratheon", "Joffrey Baratheon é o Príncipe Herdeiro dos Sete Reinos. Ele é o filho mais velho de Cersei Lannister e seu irmão, Jamie Lannister. Joffrey, era tido como filho de Robert, mas foi descoberto que ele não é o real herdeiro do Trono de Ferro."));
        listaGOT.add(new GameOfThrones(300, "Robert Baratheon", "Robert Baratheon é o Rei dos Sete Reinos. Ele foi coroado após liderar uma rebelião contra o Rei Aerys II Targaryen."));
        listaGOT.add(new GameOfThrones(400, "Sandor Clegane", "Sandor Clegane, conhecido como \"Cão de Caça\", é o irmão mais jovem de Sor Gregor Clegane e vassalo da Casa Lannister"));
        listaGOT.add(new GameOfThrones(500, "Theon Greyjoy", "Theon Greyjoy é o filho mais novo de Lorde Balon Greyjoy das Ilhas de Ferro. Ele é o protegido e escudeiro de Lorde Eddard Stark, resultante da mal sucedida Rebelião dos Greyjoy."));
        listaGOT.add(new GameOfThrones(600, "Cersei Lannister", "Cersei Lannister, Rainha dos Sete Reinos de Westeros, é a esposa do Rei Robert Baratheon."));
        listaGOT.add(new GameOfThrones(700, "Jaime Lannister", "Sir Jaime Lannister é um membro da Guarda Real. Ele recebeu o apelido de \"Regicida\" por matar o Rei Aerys Targaryen II, que ele jurou proteger. Ele é o irmão gêmeo da Rainha."));
        listaGOT.add(new GameOfThrones(800, "Tyrion Lannister", "Chamado de \"Duende\", Tyrion Lannister é o irmão mais novo de Cersei e Jaime. Ele é um anão e sua mãe morreu no parto, com seu pai o culpando."));
        listaGOT.add(new GameOfThrones(900, "Jorah Mormont", "Sor Jorah Mormont é um cavaleiro exilado a serviço de Daenerys Targaryen. Ele foi exilado por Lorde Stark por comerciar escravos. Ele é filho de Jeor Mormont da Patrulha da Noite."));
        listaGOT.add(new GameOfThrones(1000, "Jon Snow", "Jon Snow é o filho bastardo de Lorde Eddard Stark de Winterfell. Eddard jamais revelou quem era sua mãe."));
        listaGOT.add(new GameOfThrones(1100, "Arya Stark", "Arya Stark é a terceira filha e a mais jovem menina de Lorde Eddard Stark e Catelyn Stark de Winterfell."));
        listaGOT.add(new GameOfThrones(1200, "Bran Stark", "Brandon Stark é o quarto filho e o segundo menino de Lorde Eddard Stark e Catelyn Stark. Nomeado em homenagem a \"Brandon, o Construtor\", o homem que construíu a Muralha."));
        listaGOT.add(new GameOfThrones(1300, "Catelyn Stark", "Catelyn Stark, Lady de Winterfell, é a esposa de Lorde Eddard. Filha de Lorde Hoster Tully, Senhor do Tridente, sua irmã é Lysa Arryn, Lady do Vale de Arryn e Senhora do Ninho da Águia."));
        listaGOT.add(new GameOfThrones(1400, "Eddard Stark", "Eddard Stark, Lorde de Winterfell e Guardião do Norte, é a Mão do Rei após a morte de Jon Arryn. Informalmente chamado de \"Ned\", ele é conhecido por seu senso de justiça e honra."));
        listaGOT.add(new GameOfThrones(1500, "Robb Stark", "Robb Stark é o filho mais velho de Lorde Eddard e de Lady Catelyn e herdeiro de Winterfell."));
        listaGOT.add(new GameOfThrones(1600, "Sansa Stark", "Sansa Stark é a segunda filha e a primeira menina de Eddard e Catelyn Stark. Ela é a futura esposa do Princípe Joffrey."));
        listaGOT.add(new GameOfThrones(1700, "Daenerys Targaryen", "Daenerys Targaryen é uma exilada princesa da dinastia Targaryen. Também conhecida como \"Nascida da Tormenta\", ela e seu irmão foram levados a Essos por Sor Willem Darry."));
        listaGOT.add(new GameOfThrones(1800, "Viserys Targaryen", "Viserys Targaryen é um príncipe exilado e o herdeiro da dinastia Targaryen. Conhecido como \"Rei Pedinte\" por procurar um exército para recapturar seu trono."));
    }

    public static BancoDados getInstance() {
        return BancoDadosHolder.INSTANCE;
    }

    @Override
    public List<GameOfThrones> pesquisar(GameOfThrones obj) {
        if(obj==null) {
            return new ArrayList<>(listaGOT);
        }
        TreeSet<GameOfThrones> lista = new TreeSet<>();
        for (GameOfThrones c : listaGOT) {
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
    public GameOfThrones consultar(GameOfThrones obj) {
        for (GameOfThrones c : listaGOT) {
            if (c.equals(obj)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(GameOfThrones obj) {
        return listaGOT.remove(obj);
    }

    @Override
    public GameOfThrones salvar(GameOfThrones obj) {
        listaGOT.remove(obj);
        listaGOT.add(obj);
        return obj;
    }

}
