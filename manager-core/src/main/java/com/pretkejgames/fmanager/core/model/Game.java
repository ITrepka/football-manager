package com.pretkejgames.fmanager.core.model;

import java.io.IOException;
import java.util.List;

public class Game {
    Save save;
    Manager manager;
    League league;

    public Game(Manager manager, Club club, League league) throws IOException {
        this.manager = manager;
        manager.setClub(club);
        this.league = league;
    }

    public Game(Manager manager, League league, Save save) { //load database
        this.manager = manager;
        this.league = league;
        this.save = save;
    }

    public void playMatchday() {
        league.getSchedule().getQueue().playQueque();
    }

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }

    public League getLeague() {
        return league;
    }
}
