package com.pretkejgames.fmanager.core.model;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.pretkejgames.fmanager.core.DAOS.GameDao;
import com.pretkejgames.fmanager.core.model.League;
import com.pretkejgames.fmanager.core.model.Match;
import com.pretkejgames.fmanager.core.model.MatchQueue;
import com.pretkejgames.fmanager.core.model.Schedule;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Generator {


    //todo
    public static Schedule generateSchedule (List<Club> clubs) {
        Set<MatchQueue> queues = new HashSet<>();
        do {
            queues.add(generateSetMatchesQueue(clubs, queues.size() + 1));
        } while (queues.size() < 2 * (clubs.size() - 1));
        //todo kolejnosc
        return new Schedule(new ArrayList<>(queues));
    }

    private static MatchQueue generateSetMatchesQueue(List<Club> clubs, int number) {
        Set<Match> matches = new HashSet<>();
        Random random = new Random();
        do {
            int homeClubIndex = random.nextInt(clubs.size());
            int awayClubIndex = random.nextInt(clubs.size());
            if (homeClubIndex != awayClubIndex) {
                matches.add(new Match(clubs.get(homeClubIndex), clubs.get(awayClubIndex)));
            }
        }while (matches.size() < clubs.size() / 2);
        return new MatchQueue(matches, number);
    }

}
