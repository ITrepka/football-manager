package com.pretkejgames.fmanager.core;

import java.util.Set;

public class Club {
    private String name;
    private int points;
    private int goalScored;
    private int lostGoals;
    private int goalDifferential;
    private int championshipWon;

    public Club(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setChampionshipWon(int championshipWon) {
        this.championshipWon = championshipWon;
    }

    public void setGoalScored(int goalScored) {
        this.goalScored = goalScored;
    }

    public void setLostGoals(int lostGoals) {
        this.lostGoals = lostGoals;
    }

    public void setGoalDifferential(int goalDifferential) {
        this.goalDifferential = goalDifferential;
    }
}
