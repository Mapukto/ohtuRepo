package statistics.matcher;

import statistics.Player;

public class MatcherTehdas {
    Matcher matcher;

    public MatcherTehdas() {
        matcher = new Matcher() {
            @Override
            public boolean matches(Player p) {
                return true;
            }
        };
    }

    public MatcherTehdas HasFewerThan(int a, String cat) {
        this.matcher = new HasFewerThan(a, cat);
        return this;
    }

    public MatcherTehdas HasAtLeast(int a, String cat) {
        this.matcher = new HasAtLeast(a, cat);
        return this;
    }

    public MatcherTehdas PlaysIn(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }

    public Matcher build() {
        return matcher;
    }

    Matcher And(Matcher... matchers) {
        //...
    }
}
