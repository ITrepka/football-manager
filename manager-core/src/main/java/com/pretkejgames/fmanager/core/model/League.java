package com.pretkejgames.fmanager.core.model;

import java.io.File;
import java.util.List;
import java.util.Set;

public class League {
    private Set<Club> clubs;
    private Schedule schedule;

    public League(Set<Club> clubs) {
        this.clubs = clubs;
        this.schedule = Generator.generateSchedule(clubs);
    }

    public static League loadLeague(File clubs) {
        return null;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void addClub() {
        //todo
    }

    public void removeClub() {
        //todo
    }


}
