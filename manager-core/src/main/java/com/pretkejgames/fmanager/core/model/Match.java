package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.Club;

public class Match {
    private Club homeClub;
    private Club awayClub;

    public Match(Club homeClub, Club awayClub) {
        this.homeClub = homeClub;
        this.awayClub = awayClub;
    }

    public String playMatch() {
        //todo
        return "";
    }
}
