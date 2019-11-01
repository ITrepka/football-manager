package com.pretkejgames.fmanager.core.model;
import static com.pretkejgames.fmanager.core.model.ResultType.*;

public class ResultFactory {
    public static ResultType getResultType(Integer team1Goals, Integer team2Goals) {
        int ratio = team1Goals - team2Goals;
        return ratio > 0 ? WIN : ratio == 0 ? DRAW : LOSE;
    }
}
