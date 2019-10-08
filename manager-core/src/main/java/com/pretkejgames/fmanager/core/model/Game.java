package com.pretkejgames.fmanager.core.model;

import java.util.Map;
import java.util.Set;

public class Game {
    Save save;
    Manager manager;
    League league;

    public Game(Manager manager, Club club) {
        this.manager = manager;
        manager.setClub(club);
        this.league = League.loadLeague(Data.leagues)
                .add(club);
    }

    public void playMatchday() {
        league.getSchedule().getQueue().playQueque();
    }

    public void newGameAutoSave() {
        if (this.save == null) {
            this.save = new Save("startGame");
        }
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
