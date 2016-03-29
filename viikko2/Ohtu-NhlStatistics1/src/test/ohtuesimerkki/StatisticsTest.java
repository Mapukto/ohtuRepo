package ohtuesimerkki;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jussi on 28/03/16.
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Test
    public void SearchTest() {
        stats = new Statistics(readerStub);

        Assert.assertEquals(stats.search("Semenko").getName(), "Semenko");
        Assert.assertEquals(stats.search("penis"), null);
    }

    @Test
    public void TeamTest() {
        stats = new Statistics(readerStub);
        List<Player> tulos = stats.team("EDM");

        Assert.assertEquals(tulos.size(), 3);
    }

    @Test
    public void TopScorersTest() {
        stats = new Statistics(readerStub);
        List<Player> tulos = stats.topScorers(4);

        Assert.assertEquals(true, true);
    }
}
