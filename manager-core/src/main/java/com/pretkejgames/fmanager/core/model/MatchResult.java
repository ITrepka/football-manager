package com.pretkejgames.fmanager.core.model;

public class MatchResult {
    private Integer homeTeamGoals;
    private Integer awayTeamGoals;
    private ResultType resultHome;
    private ResultType resultAway;

    public MatchResult(Integer homeTeamGoals, Integer awayTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
        resultHome = ResultFactory.getResultType(homeTeamGoals, awayTeamGoals);
        resultAway = ResultFactory.getResultType(awayTeamGoals, homeTeamGoals);
    }

    public ResultType getResultHome() {
        return resultHome;
    }

    public void setResultHome(ResultType resultHome) {
        this.resultHome = resultHome;
    }

    public ResultType getResultAway() {
        return resultAway;
    }

    public void setResultAway(ResultType resultAway) {
        this.resultAway = resultAway;
    }

    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }
}
