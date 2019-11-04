package com.pretkejgames.fmanager.core.model;

import java.util.List;

public class League {
    private List<Club> clubs;
    private Schedule schedule;

    public League(List<Club> clubs) {
        this.clubs = clubs;
        this.schedule = ScheduleService.generateSchedule(clubs);
    }

    public static League loadLeague(List<Club> clubs) {
        return new League(clubs);
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public League addClub(Club club) {
        //todo
        clubs.add(club);
        return new League(this.clubs);
    }

    public void removeClub() {
        //todo
    }

    @Override
    public String toString() {
        return String.format("LEAGUE,%s,%s", clubs, schedule);
    }
}
