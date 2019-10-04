package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.MatchQueue;

import java.util.HashSet;
import java.util.Set;

public class Schedule {
    Set<MatchQueue> matchQueues = new HashSet<>();

    public Schedule(Set<MatchQueue> matchQueues) {
        this.matchQueues = matchQueues;
    }
}
