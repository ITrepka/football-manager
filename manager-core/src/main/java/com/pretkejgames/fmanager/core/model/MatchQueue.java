package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.Match;

import java.util.Set;

public class MatchQueue {
    private Set<Match> matches;
    private int number;

    public MatchQueue(Set<Match> matches, int number) {
        this.matches = matches;
        this.number = number;
    }
}
