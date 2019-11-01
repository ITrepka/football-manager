package com.pretkejgames.fmanager.core.model;

import java.util.Objects;
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

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public int getLostGoals() {
        return lostGoals;
    }

    public int getGoalDifferential() {
        return goalDifferential;
    }

    public int getChampionshipWon() {
        return championshipWon;
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

    public void calculateGoalDifferential() {
        goalDifferential = goalScored - lostGoals;
    }

    @Override
    public String toString() {
        return String.format("CLUB,%s,%d,%d,%d,%d,%d", name, points, goalScored, lostGoals, goalDifferential, championshipWon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return name.equals(club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addScoredGoals(int goalScored) {
        this.goalScored += goalScored;
    }

    public void addLostGoals(int lostGoals) {
        this.lostGoals += lostGoals;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
