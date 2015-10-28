package com.senac.fake;

import com.senac.bean.Musica;
import com.senac.crud.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BancoDadosMusica implements CrudGenerico<Musica> {

    private static final Set<Musica> musicas = new TreeSet<>();

    public BancoDadosMusica() {
        int id = 1000;
        musicas.add(new Musica((id += 100), "Rolling Stones", "(I Can't Get No) Satisfaction"));
        musicas.add(new Musica((id += 100), "The Temptations", "My Girl"));
        musicas.add(new Musica((id += 100), "Smokey Robinson", "The Tracks Of My Tears"));
        musicas.add(new Musica((id += 100), "The Byrds", "Mr. Tambourine Man"));
        musicas.add(new Musica((id += 100), "The Kinks", "You Really Got Me"));
        musicas.add(new Musica((id += 100), "Righteous Brothers", "You've Lost That Lovin' Feeling"));
        musicas.add(new Musica((id += 100), "Sam Cooke", "A Change is Gonna Come"));
        musicas.add(new Musica((id += 100), "Bob Dylan", "Like A Rolling Stone"));
        musicas.add(new Musica((id += 100), "The Beatles", "A Hard Day's Night"));
        musicas.add(new Musica((id += 100), "Kingsmen", "Louie Louie"));
        musicas.add(new Musica((id += 100), "Ronettes", "Be My Baby"));
        musicas.add(new Musica((id += 100), "Roy Orbison", "Crying"));
        musicas.add(new Musica((id += 100), "The Shirelles", "Will You Still Love Me Tomorrow?"));
        musicas.add(new Musica((id += 100), "Ray Charles", "What'd i Say"));
        musicas.add(new Musica((id += 100), "Chuck Berry", "Johnny B. Goode"));
        musicas.add(new Musica((id += 100), "Little Richard", "Tutti Frutti"));
        musicas.add(new Musica((id += 100), "Buddy Holly", "That'll Be The Day"));
        musicas.add(new Musica((id += 100), "Elvis Presley", "That's All Right"));
        musicas.add(new Musica((id += 100), "The Beach Boys", "California Girls"));
        musicas.add(new Musica((id += 100), "The Who", "Substitute"));
        musicas.add(new Musica((id += 100), "Ike and Tina Turner", "River Deep, Mountain High"));
        musicas.add(new Musica((id += 100), "The Byrds", "Eight Miles High"));
        musicas.add(new Musica((id += 100), "The Beatles", "Strawberry Fields Forever"));
        musicas.add(new Musica((id += 100), "The Kinks", "Waterloo Sunset"));
        musicas.add(new Musica((id += 100), "Velvet Underground", "Venus In Furs"));
        musicas.add(new Musica((id += 100), "Jimi Hendrix", "Purple Haze"));
        musicas.add(new Musica((id += 100), "The Beach Boys", "Good Vibrations"));
        musicas.add(new Musica((id += 100), "Jefferson Airplane", "White Rabbit"));
        musicas.add(new Musica((id += 100), "The Doors", "Break On Through (To the Other Side)"));
        musicas.add(new Musica((id += 100), "Procol Harum", "A Whiter Shade of Pale"));
        musicas.add(new Musica((id += 100), "Aretha Franklin", "Respect"));
        musicas.add(new Musica((id += 100), "Otis Redding", "Sitting On The Dock Of The Bay"));
        musicas.add(new Musica((id += 100), "The Beatles", "Hey Jude"));
        musicas.add(new Musica((id += 100), "The Zombies", "Time Of The Season"));
        musicas.add(new Musica((id += 100), "Marvin Gaye", "I Heard It Through The Grapevine"));
        musicas.add(new Musica((id += 100), "Creedence Clearwater Revival", "Fortunate Son"));
        musicas.add(new Musica((id += 100), "Elvis Presley", "Suspicious Minds"));
        musicas.add(new Musica((id += 100), "The Band", "The Night They Drove Old Dixie Down"));
        musicas.add(new Musica((id += 100), "Led Zeppelin", "Whole Lotta Love"));
        musicas.add(new Musica((id += 100), "Sly And The Family Stone", "I Want To Take You Higher"));
        musicas.add(new Musica((id += 100), "The Stooges", "1969"));
        musicas.add(new Musica((id += 100), "David Bowie", "Changes"));
        musicas.add(new Musica((id += 100), "Nick Drake", "Northern sky"));
        musicas.add(new Musica((id += 100), "Simon & Garfunkel", "Bridge Over Troubled Water"));
        musicas.add(new Musica((id += 100), "James Brown", "Sex Machine"));
        musicas.add(new Musica((id += 100), "Black Sabbath", "Paranoid"));
        musicas.add(new Musica((id += 100), "Derek And The Dominos", "Layla"));
        musicas.add(new Musica((id += 100), "The Who", "Won't Get Fooled Again"));
        musicas.add(new Musica((id += 100), "Rolling Stones", "Brown Sugar"));
        musicas.add(new Musica((id += 100), "Marvin Gaye", "What's Going On"));
        musicas.add(new Musica((id += 100), "Yes", "Roundabout"));
        musicas.add(new Musica((id += 100), "Jimmy Cliff", "The Harder They Come"));
        musicas.add(new Musica((id += 100), "Elton John", "Rocket Man"));
        musicas.add(new Musica((id += 100), "Big Star", "The Ballad of El Goodo"));
        musicas.add(new Musica((id += 100), "Stevie Wonder", "Higher Ground"));
        musicas.add(new Musica((id += 100), "Gram Parsons", "$1000 Wedding"));
        musicas.add(new Musica((id += 100), "Queen", "Bohemian Rhapsody"));
        musicas.add(new Musica((id += 100), "Bob Marley", "No Woman No Cry"));
        musicas.add(new Musica((id += 100), "Bruce Springsteen", "Thunder Road"));
        musicas.add(new Musica((id += 100), "Sex Pistols", "Anarchy In The U.K."));
        musicas.add(new Musica((id += 100), "Ramones", "Sheena Is A Punk Rocker"));
        musicas.add(new Musica((id += 100), "David Bowie", "Heroes"));
        musicas.add(new Musica((id += 100), "Bee Gees", "Stayin' Alive"));
        musicas.add(new Musica((id += 100), "Elvis Costello", "Alison"));
        musicas.add(new Musica((id += 100), "Kraftwerk", "The Robots"));
        musicas.add(new Musica((id += 100), "Blondie", "Heart Of Glass"));
        musicas.add(new Musica((id += 100), "The Clash", "London Calling"));
        musicas.add(new Musica((id += 100), "Chic", "Good Times"));
        musicas.add(new Musica((id += 100), "The Police", "Message In A Bottle"));
        musicas.add(new Musica((id += 100), "Pink Floyd", "Comfortably Numb"));
        musicas.add(new Musica((id += 100), "Neil Young", "My My, Hey Hey (Out of the blue)"));
        musicas.add(new Musica((id += 100), "Joy Division", "Love Will Tear Us Apart"));
        musicas.add(new Musica((id += 100), "Motörhead", "Ace Of Spades"));
        musicas.add(new Musica((id += 100), "Talking Heads", "Once In A Lifetime"));
        musicas.add(new Musica((id += 100), "Soft Cell", "Tainted Love"));
        musicas.add(new Musica((id += 100), "Prince", "1999"));
        musicas.add(new Musica((id += 100), "Michael Jackson", "Billie Jean"));
        musicas.add(new Musica((id += 100), "New Order", "Blue Monday"));
        musicas.add(new Musica((id += 100), "R.E.M.", "Radio Free Europe"));
        musicas.add(new Musica((id += 100), "Madonna", "Like A Virgin"));
        musicas.add(new Musica((id += 100), "The Smiths", "How Soon Is Now?"));
        musicas.add(new Musica((id += 100), "Run DMC", "Walk This Way"));
        musicas.add(new Musica((id += 100), "Guns N' Roses", "Welcome To The Jungle"));
        musicas.add(new Musica((id += 100), "My Bloody Valentine", "You Made Me Realise"));
        musicas.add(new Musica((id += 100), "Public Enemy", "Fight The Power"));
        musicas.add(new Musica((id += 100), "The Stone Roses", "She Bangs The Drums"));
        musicas.add(new Musica((id += 100), "Pixies", "Debaser"));
        musicas.add(new Musica((id += 100), "U2", "One"));
        musicas.add(new Musica((id += 100), "Nirvana", "Smells Like Teen Spirit"));
        musicas.add(new Musica((id += 100), "Massive Attack", "Unfinished Sympathy"));
        musicas.add(new Musica((id += 100), "Metallica", "Enter Sandman"));
        musicas.add(new Musica((id += 100), "Pearl Jam", "Jeremy"));
        musicas.add(new Musica((id += 100), "Oasis", "Live Forever"));
        musicas.add(new Musica((id += 100), "Pulp", "Common People"));
        musicas.add(new Musica((id += 100), "Underworld", "Born Slippy"));
        musicas.add(new Musica((id += 100), "Radiohead", "Paranoid Android"));
        musicas.add(new Musica((id += 100), "The Flaming Lips", "Do You Realize?"));
        musicas.add(new Musica((id += 100), "White Stripes", "Seven Nation Army"));
        musicas.add(new Musica((id += 100), "OutKast", "Hey Ya!"));
        musicas.add(new Musica((id += 100), "Green Day", "Wake Me Up When September Ends"));
    }

    public static BancoDadosMusica getInstance() {
        return BancoDadosMusica.BancoDadosHolder.INSTANCE;
    }

    private static class BancoDadosHolder {

        private static final BancoDadosMusica INSTANCE = new BancoDadosMusica();
    }

    @Override
    public Musica consultar(Musica obj) {
        for (Musica m : musicas) {
            if (m.equals(obj)) {
                return m;
            }
        }
        return null;    
    }

    @Override
    public boolean excluir(Musica obj) {
        return musicas.remove(obj);
    }

    @Override
    public List<Musica> pesquisar(Musica obj) {
        if (obj == null) {
            return new ArrayList<>(musicas);
        }
        TreeSet<Musica> lista = new TreeSet<>();
        for (Musica m : musicas) {
            if (m.getId() == obj.getId()
                    || (obj.getArtista() != null && m.getArtista().contains(obj.getArtista()))
                    || (obj.getMusica() != null && m.getMusica().contains(obj.getMusica()))) {
                lista.add(m);
            }
        }
        return new ArrayList<>(lista);
    }

    @Override
    public Musica salvar(Musica obj) {
        musicas.remove(obj);
        musicas.add(obj);
        return obj;
    }

}
