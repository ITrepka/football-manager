package com.pretkejgames.fmanager.core;

import java.util.Set;

public class Generator {
    //todo
    public static Schedule generateSchedule (League league) {
        Set<MatchQueue> queues = generateSetMatchesQueue(league);




        return new Schedule(new Set<MatchQueue>(new Set<Match>(), order));
    }

}
