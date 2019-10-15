package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.Match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MatchQueue {
    private Set<Match> matches;
    private int number;
    private boolean wasPlayed;
    Map<Match, String> results;

    public MatchQueue(Set<Match> matches, int number) {
        this.matches = matches;
        this.number = number;
    }

    public void playQueque() {
        Map<Match, String> queueResults = new HashMap<>();
        for (Match match : matches) {
            queueResults.put(match, match.playMatch());
        }
        wasPlayed = true;
        results = queueResults;
    }

    public Map<Match, String> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return String.format("MATCHQUEUE,%s,%d,%b,results",matches,number,wasPlayed,results);
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

    public void setWasPlayed(boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }
}
