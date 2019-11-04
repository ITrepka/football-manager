package com.pretkejgames.fmanager.core.model;
import java.util.Objects;
import java.util.Random;

public class Match {
    private Club homeClub;
    private Club awayClub;
    private MatchResult result;
    private boolean wasPlayed;

    public Match(Club homeClub, Club awayClub) {
        this.homeClub = homeClub;
        this.awayClub = awayClub;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

    public boolean isWasPlayed() {
        return wasPlayed;
    }

    public void setWasPlayed(boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }

    @Override
    public String toString() {
        return String.format("MATCH:%s,%s",homeClub,awayClub);
    }

    public MatchResult getResult() {
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
        return homeClub.equals(comparedMatch.homeClub) && awayClub.equals(comparedMatch.awayClub) ||
                awayClub.equals(comparedMatch.homeClub) && homeClub.equals(comparedMatch.awayClub) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeClub, awayClub);
    }
}
