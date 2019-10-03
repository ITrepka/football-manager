package com.pretkejgames.fmanager.core;

import java.util.Set;

public class MatchQueue {
    private Set<Match> matches;
    private int number;

    public MatchQueue(Set<Match> matches, int number) {
        this.matches = matches;
        this.number = number;
    }
}
