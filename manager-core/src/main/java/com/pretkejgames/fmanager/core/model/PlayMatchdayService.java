package com.pretkejgames.fmanager.core.model;

import java.util.Random;

public class PlayMatchdayService {
    public void playMatchDay(MatchQueue queue) {
        for (Match match : queue.getMatches()) {
            playMatch(match);
        }
    }

    private void playMatch(Match match) {
            Random random = new Random();
            int goalHome = random.nextInt(6) + 1;
            int goalAway = random.nextInt(6) + 1;
            match.setResult(new MatchResult(goalHome, goalAway));
            match.setWasPlayed(true);
    }
}
