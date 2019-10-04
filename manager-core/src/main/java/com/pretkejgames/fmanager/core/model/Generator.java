package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.League;
import com.pretkejgames.fmanager.core.model.Match;
import com.pretkejgames.fmanager.core.model.MatchQueue;
import com.pretkejgames.fmanager.core.model.Schedule;

import java.util.Set;

public class Generator {
    //todo
    public static Schedule generateSchedule (League league) {
        Set<MatchQueue> queues = generateSetMatchesQueue(league);




        return new Schedule(new Set<MatchQueue>(new Set<Match>(), order));
    }

}
