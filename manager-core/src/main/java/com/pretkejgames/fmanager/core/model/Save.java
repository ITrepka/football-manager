package com.pretkejgames.fmanager.core.model;

public class Save {
    private String name;

    public Save () {
        this.name = "autosave";
    }

    public Save(String name) {
        //todo
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
