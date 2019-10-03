package com.pretkejgames.fmanager.core;

import java.util.Collection;
import java.util.Set;

public class League {
    Set<Club> clubs;
    Schedule schedule;

    public League(Set<Club> clubs) {
        this.clubs = clubs;
        this.schedule = Generator.generateSchedule(clubs);
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
