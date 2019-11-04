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

public class ScheduleService {
    //todo
    public static Schedule generateSchedule (List<Club> clubs) {
        List<MatchQueue> queues = new ArrayList<>();
        do {
            System.out.println(queues.size());
            List<Club> clubsCopy = new ArrayList<>(clubs);
            MatchQueue generatedMatchQueue = generateSetMatchesQueue(clubsCopy, queues.size() + 1);
            if (!queues.contains(generatedMatchQueue)) {
                queues.add(generatedMatchQueue);
            }
        } while (queues.size() < clubs.size() - 1);

        addRevangesRound(queues);
        //todo kolejnosc
        return new Schedule(queues);
    }

    private static void addRevangesRound(List<MatchQueue> queues) {
        int queueSizeAfterFirstRound = queues.size();
        for (int i = 0; i < queueSizeAfterFirstRound; i++) {
                Set<Match> matches = new HashSet<>();
            for (Match match: queues.get(i).getMatches()){
                matches.add(new Match(match.getAwayClub(), match.getHomeClub()));
            }
            queues.add(new MatchQueue(matches, queues.size() + 1));
        }
    }

    private static MatchQueue generateSetMatchesQueue(final List<Club> clubs, int number) {
        Set<Match> matches = new HashSet<>();
        Random random = new Random();
        do {
            int homeClubIndex = random.nextInt(clubs.size());
            int awayClubIndex = random.nextInt(clubs.size());
            if (homeClubIndex != awayClubIndex) {
                matches.add(new Match(clubs.get(homeClubIndex), clubs.get(awayClubIndex)));
                clubs.remove(clubs.get(Math.max(homeClubIndex, awayClubIndex)));
                clubs.remove(clubs.get(Math.min(homeClubIndex, awayClubIndex)));
            }
        }while (clubs.size() > 0);
        return new MatchQueue(matches, number);
    }

}
