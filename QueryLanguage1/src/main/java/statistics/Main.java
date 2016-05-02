package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        /**
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        **/

        MatcherTehdas MT = new MatcherTehdas();

        Matcher m1 = MT.HasAtLeast(10, "goals").HasAtLeast(10, "assists").PlaysIn("PHI").build();

        for (Player player : stats.matches(m1)) {
            System.out.println( player );
        }
    }
}
