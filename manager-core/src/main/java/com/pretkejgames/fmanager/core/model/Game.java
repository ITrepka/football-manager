package com.pretkejgames.fmanager.core.model;

import com.pretkejgames.fmanager.core.model.Club;

import java.util.Set;

public class Game {
    String save;
    Manager manager;
    Rules rules;

    public Game(Manager manager) {
        this.manager = manager;
    }
}
