package com.senac.fake;

import com.senac.bean.Personagem;
import com.senac.crud.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BancoDadosPersonagem implements CrudGenerico<Personagem> {

    private TreeSet<Personagem> listagem;

    private BancoDadosPersonagem() {
        listagem = new TreeSet<>();
        
        // dados fake        
        listagem.add(new Personagem(100, "Petyr Baelish", "Lorde Petyr Baelish, chamado de 'Mindinho', é o Mestre da Moeda do Pequeno Conselho. Ele cresceu com Catelyn Tully e lutou por sua mão com o irmão de Eddard Stark, Brandon Stark"));
        listagem.add(new Personagem(200, "Joffrey Baratheon", "Joffrey Baratheon é o Príncipe Herdeiro dos Sete Reinos. Ele é o filho mais velho de Cersei Lannister e seu irmão, Jamie Lannister. Joffrey, era tido como filho de Robert, mas foi descoberto que ele não é o real herdeiro do Trono de Ferro."));
        listagem.add(new Personagem(300, "Robert Baratheon", "Robert Baratheon é o Rei dos Sete Reinos. Ele foi coroado após liderar uma rebelião contra o Rei Aerys II Targaryen."));
        listagem.add(new Personagem(400, "Sandor Clegane", "Sandor Clegane, conhecido como 'Cão de Caça', é o irmão mais jovem de Sor Gregor Clegane e vassalo da Casa Lannister"));
        listagem.add(new Personagem(500, "Theon Greyjoy", "Theon Greyjoy é o filho mais novo de Lorde Balon Greyjoy das Ilhas de Ferro. Ele é o protegido e escudeiro de Lorde Eddard Stark, resultante da mal sucedida Rebelião dos Greyjoy."));
        listagem.add(new Personagem(600, "Cersei Lannister", "Cersei Lannister, Rainha dos Sete Reinos de Westeros, é a esposa do Rei Robert Baratheon."));
        listagem.add(new Personagem(700, "Jaime Lannister", "Sir Jaime Lannister é um membro da Guarda Real. Ele recebeu o apelido de 'Regicida' por matar o Rei Aerys Targaryen II, que ele jurou proteger. Ele é o irmão gêmeo da Rainha."));
        listagem.add(new Personagem(800, "Tyrion Lannister", "Chamado de 'Duende', Tyrion Lannister é o irmão mais novo de Cersei e Jaime. Ele é um anão e sua mãe morreu no parto, com seu pai o culpando."));
        listagem.add(new Personagem(900, "Jorah Mormont", "Sor Jorah Mormont é um cavaleiro exilado a serviço de Daenerys Targaryen. Ele foi exilado por Lorde Stark por comerciar escravos. Ele é filho de Jeor Mormont da Patrulha da Noite."));
        listagem.add(new Personagem(1000, "Jon Snow", "Jon Snow é o filho bastardo de Lorde Eddard Stark de Winterfell. Eddard jamais revelou quem era sua mãe."));
        listagem.add(new Personagem(1100, "Arya Stark", "Arya Stark é a terceira filha e a mais jovem menina de Lorde Eddard Stark e Catelyn Stark de Winterfell."));
        listagem.add(new Personagem(1200, "Bran Stark", "Brandon Stark é o quarto filho e o segundo menino de Lorde Eddard Stark e Catelyn Stark. Nomeado em homenagem a 'Brandon, o Construtor', o homem que construíu a Muralha."));
        listagem.add(new Personagem(1300, "Catelyn Stark", "Catelyn Stark, Lady de Winterfell, é a esposa de Lorde Eddard. Filha de Lorde Hoster Tully, Senhor do Tridente, sua irmã é Lysa Arryn, Lady do Vale de Arryn e Senhora do Ninho da Águia."));
        listagem.add(new Personagem(1400, "Eddard Stark", "Eddard Stark, Lorde de Winterfell e Guardião do Norte, é a Mão do Rei após a morte de Jon Arryn. Informalmente chamado de 'Ned', ele é conhecido por seu senso de justiça e honra."));
        listagem.add(new Personagem(1500, "Robb Stark", "Robb Stark é o filho mais velho de Lorde Eddard e de Lady Catelyn e herdeiro de Winterfell."));
        listagem.add(new Personagem(1600, "Sansa Stark", "Sansa Stark é a segunda filha e a primeira menina de Eddard e Catelyn Stark. Ela é a futura esposa do Princípe Joffrey."));
        listagem.add(new Personagem(1700, "Daenerys Targaryen", "Daenerys Targaryen é uma exilada princesa da dinastia Targaryen. Também conhecida como 'Nascida da Tormenta', ela e seu irmão foram levados a Essos por Sor Willem Darry."));
        listagem.add(new Personagem(1800, "Viserys Targaryen", "Viserys Targaryen é um príncipe exilado e o herdeiro da dinastia Targaryen. Conhecido como 'Rei Pedinte' por procurar um exército para recapturar seu trono."));
    }

    public static BancoDadosPersonagem getInstance() {
        return BancoDadosHolder.INSTANCE;
    }

    @Override
    public List<Personagem> pesquisar(Personagem obj) {
        if(obj==null) {
            return new ArrayList<>(listagem);
        }
        TreeSet<Personagem> lista = new TreeSet<>();
        for (Personagem p : listagem) {
            if (p.getCodigo().equals(obj.getCodigo())
                    || (obj.getNome()!=null && p.getNome().contains(obj.getNome()))) {
                lista.add(p);
            }
        }
        return new ArrayList<>(lista);
    }

    private static class BancoDadosHolder {

        private static final BancoDadosPersonagem INSTANCE = new BancoDadosPersonagem();
    }

    @Override
    public Personagem consultar(Personagem obj) {
        for (Personagem p : listagem) {
            if (p.equals(obj)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Personagem obj) {
        return listagem.remove(obj);
    }

    @Override
    public Personagem salvar(Personagem obj) {
        listagem.remove(obj);
        listagem.add(obj);
        return obj;
    }

}
