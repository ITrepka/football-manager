package com.pretkejgames.fmanager.core.model;

import java.util.*;
import java.util.List;

public class ScheduleService {
    private static int TEAMS_QUANTITY;

    //todo
    public static Schedule generateSchedule(List<Club> clubs) {
        TEAMS_QUANTITY = clubs.size();
        List<Club> clubsCopy = new ArrayList<>(clubs);
        List<Club> clubsRandomOrder = changeOrderInList(clubsCopy);
        List<MatchQueue> queues = generateQueues(clubsRandomOrder);
        List<MatchQueue> queuesWithRevangesRound = createRevangesRound(queues);
        //todo kolejnosc
        return new Schedule(queuesWithRevangesRound);
    }

    private static List<MatchQueue> generateQueues(List<Club> clubsRandomOrder) {
        LinkedList<Club>[] parts = shareClubsOnTwoParts(clubsRandomOrder);
        LinkedList<Club> upperPart = parts[0];
        LinkedList<Club> lowerPart = parts[1];
        List<MatchQueue> queues = new ArrayList<>();
        for (int queueNumber = 1; queueNumber < TEAMS_QUANTITY; queueNumber++) {
            queues.add(generateMatchQueue(queueNumber, upperPart, lowerPart));
            //change position
            swapListRound(upperPart, lowerPart);
        }
        return queues;
    }

    private static void swapListRound(LinkedList<Club> upperPart, LinkedList<Club> lowerPart) {
        upperPart.add(1, lowerPart.removeFirst());
        lowerPart.addLast(upperPart.removeLast());
    }

    private static MatchQueue generateMatchQueue(int queueNumber, LinkedList<Club> upperPart, LinkedList<Club> lowerPart) {
        Set<Match> matches;
        if (queueNumber % 2 != 0) {
            matches = generateMatches(upperPart, lowerPart);
        } else {
            matches = generateMatches(lowerPart, upperPart);
        }
        return new MatchQueue(matches, queueNumber);
    }

    private static Set<Match> generateMatches(LinkedList<Club> upperPart, LinkedList<Club> lowerPart) {
        Set<Match> matches = new HashSet<>();
        for (int i = 0; i < upperPart.size(); i++) {
            Club homeTeam = upperPart.get(i);
            Club awayClub = lowerPart.get(i);
            matches.add(new Match(homeTeam, awayClub));
        }
        return matches;
    }

    private static LinkedList[] shareClubsOnTwoParts(List<Club> clubsRandomOrder) {
        LinkedList<Club> part1 = new LinkedList<>();
        LinkedList<Club> part2 = new LinkedList<>();
        int clubsLength = clubsRandomOrder.size();
        for (int i = 0; i < clubsLength; i++) {
            if (i < clubsLength / 2) {
                part1.add(clubsRandomOrder.get(i));
            } else {
                part2.addFirst(clubsRandomOrder.get(i));
            }
        }
        return new LinkedList[]{part1, part2};
    }

    private static List<Club> changeOrderInList(List<Club> clubsCopy) {
        List<Club> clubsToReturn = new ArrayList<>();
        Random r = new Random();
        do {
            int index = r.nextInt(clubsCopy.size());
            Club randomClub = clubsCopy.get(index);
            if (randomClub != null) {
                clubsToReturn.add(randomClub);
                clubsCopy.set(index, null);
            }
        } while (clubsToReturn.size() < clubsCopy.size());
        return clubsToReturn;
    }
//todo
    private static List<MatchQueue> createRevangesRound(List<MatchQueue> queues) {
        List<MatchQueue> allMatches = new ArrayList<>(queues);
        for (MatchQueue queue : queues) {
            Set<Match> matches = queue.getMatches();
            Set<Match> revangeMatches = collectRevangeMatches(matches);
            MatchQueue matchQueue = new MatchQueue(revangeMatches, allMatches.size() + 1);
            allMatches.add(matchQueue);
        }
        return allMatches;
    }

    private static Set<Match> collectRevangeMatches(Set<Match> matches) {
        Set<Match> revangeMatches = new HashSet<>();
        for (Match match: matches) {
            revangeMatches.add(new Match(match.getAwayClub(), match.getHomeClub()));
        }
        return revangeMatches;
    }
}
