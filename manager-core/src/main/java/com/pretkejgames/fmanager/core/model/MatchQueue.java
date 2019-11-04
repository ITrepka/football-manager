package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.Match;

import java.util.*;

public class MatchQueue {
    private Set<Match> matches;
    private int number;
    private boolean wasPlayed;

    public MatchQueue(Set<Match> matches, int number) {
        this.matches = matches;
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public boolean wasPlayed() {
        return wasPlayed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchQueue that = (MatchQueue) o;
        for (Match match : that.matches) {
            if (matches.contains(match)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }

    @Override
    public String toString() {
        return "MatchQueue{" +
                "matches=" + matches +
                ", number=" + number +
                ", wasPlayed=" + wasPlayed +
                '}' + "\n";
    }

    public void setWasPlayed(boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }
}
