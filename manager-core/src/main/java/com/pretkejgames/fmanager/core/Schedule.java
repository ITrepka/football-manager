package com.pretkejgames.fmanager.core;

import java.util.HashSet;
import java.util.Set;

public class Schedule {
    Set<MatchQueue> matchQueues = new HashSet<>();

    public Schedule(Set<MatchQueue> matchQueues) {
        this.matchQueues = matchQueues;
    }
}
