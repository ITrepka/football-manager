package com.pretkejgames.fmanager.core.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Schedule {
    private List<MatchQueue> matchQueues;

    public Schedule(List<MatchQueue> matchQueues) {
        this.matchQueues = matchQueues;
    }

    public MatchQueue getFirstNotPlayedQueque(int number) {
        return matchQueues.get(number);
    }

    public MatchQueue getFirstNotPlayedQueque() {
        for (MatchQueue queue : matchQueues) {
            if (!queue.wasPlayed()) {
                return queue;
            }
        }
        return null; //todo !!!
    }

    public List<MatchQueue> getMatchQueues() {
        return matchQueues;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "matchQueues=" + matchQueues +
                '}' + "\n";
    }
}
