package com.pretkejgames.fmanager.core.model;

public class Save {
    private String name;
    private static int saveID = 0;

    public Save() {
        name = "SAVE" + saveID++ + ".txt";
        //todo
    }

    public Save(String name) {
        //todo
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getSaveID() {
        return saveID;
    }
}
