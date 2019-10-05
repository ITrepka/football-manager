package com.pretkejgames.fmanager.core.model;
import java.util.Objects;
import java.util.Random;

public class Match {
    private Club homeClub;
    private Club awayClub;
    private String result;
    private boolean wasPlayed;

    public Match(Club homeClub, Club awayClub) {
        this.homeClub = homeClub;
        this.awayClub = awayClub;
    }

    public String playMatch() {
        Random random = new Random();
        int goalHome = random.nextInt(6) + 1;
        int goalAway = random.nextInt(6) + 1;
        result = goalHome+ ":" + goalAway;
        wasPlayed = true;
        return getResult();
    }

    public String getResult() {
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Match)) {
            return false;
        }
        Match comparedMatch = (Match) o;
        return homeClub.equals(comparedMatch.homeClub) && awayClub.equals(comparedMatch.awayClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeClub, awayClub);
    }
}
