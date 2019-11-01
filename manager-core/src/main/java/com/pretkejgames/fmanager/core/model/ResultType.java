package com.pretkejgames.fmanager.core.model;

public enum ResultType {
    WIN (3),
    DRAW (1),
    LOSE (0);

    public final int points;

    private ResultType(int points){
        this.points = points;
    }
}
