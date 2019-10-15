package com.pretkejgames.fmanager.core.model;

public interface Saveable {
    String MANAGER = "MANAGER";
    String LEAGUE = "LEAGUE";
    String CLUB = "CLUB";
    String GAME = "GAME";
    byte[] toCSV();
}
