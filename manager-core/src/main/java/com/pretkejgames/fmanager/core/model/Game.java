package com.pretkejgames.fmanager.core.model;

public class Game implements Saveable{
    Save save;
    Manager manager;
    League league;

    public Game(Manager manager, Club club) {
        this.manager = manager;
        manager.setClub(club);
        newGameAutoSave();
    }

    public Game(Manager manager, League league, Save save) { //load database
        this.manager = manager;
        this.league = league;
        this.save = save;
    }

    public byte[] toCSV() {
        return String.format("GAME,%s,%s", manager, league).getBytes();
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
