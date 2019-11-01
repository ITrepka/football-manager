package com.pretkejgames.fmmanager.console;

import com.pretkejgames.fmanager.core.DAOS.LeagueDAO;
import com.pretkejgames.fmanager.core.model.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private TerminalUI terminalUI;
    private Game game;

    {
        terminalUI = new TerminalUI();
    }

    public void runGame() throws IOException {
        handleMenuOptions();
    }

    private void handleMenuOptions() throws IOException {
        terminalUI.displayStartMenu();
        handleMenuChoice(terminalUI.readUserChoice());
    }

    private void handleMenuChoice(MenuOptions userMenuChoice) throws IOException {
        switch (userMenuChoice) {
            case START_NEW_GAME:
                handleStartNewGame();
                break;
            case LOAD_GAME:
//                handleLoadGame();
                break;
            case EXIT:
                exitGame();
        }
    }

    private void handleStartNewGame() throws IOException {
        Manager manager = handleCreatingManager();
        Club club = handleCreatingClub();
        LeagueDAO leagueDAO = new LeagueDAO();
        League league = new League(leagueDAO.loadClubs());
        createGame(manager, club, league);
        gameLoop();
    }

    private Club handleCreatingClub() {
        terminalUI.displayNameClubQuery();
        String clubName = terminalUI.readText();
        return new Club("clubName");
    }

    private void gameLoop() {
        int exitCode;
        do {
            terminalUI.displayGameWindow(game);
            handleGameWindowChoice(terminalUI.readUserChoiceGameWindow());
        }while (true);
    }

    private void handleGameWindowChoice(GameOptions readUserChoiceGameWindow) {
        switch (readUserChoiceGameWindow) {
            case PLAY:
                PlayOptions playWindowChoice = terminalUI.readPlayWindowChoice();
                handlePlayWindowChoice(playWindowChoice);
                break;
            case SAVE_GAME:
//                String saveName = terminalUI.readSaveName();
//                game.setSave(new Save(saveName));
                break;
            case LOAD_GAME:
//                terminalUI.showSavesList(Data.saves);
//                String saveName = terminalUI.readSaveName();
//                loadGame(saveName);
                break;
            case EXIT:
                System.exit(0);
        }
    }

    private void handlePlayWindowChoice(PlayOptions playWindowChoice) {
        switch(playWindowChoice){
            case PLAY_MATCH:
                handlePlayingMatchday();
                break;
            case DISPLAY_CURRENT_TABLE:
                handleDisplayTable();
                //todo
                break;
            case DISPLAY_SCHEDULE:
                handleDisplaySchedule();
                //todo
                break;
            case BACK:
                //todo
                break;
        }
    }

    private void handleDisplaySchedule() {
        terminalUI.displaySchedule(game.getLeague().getSchedule());
    }

    private void handleDisplayTable() {
        List<Club> clubs = game.getLeague().getClubs();
        Comparator<Club> comparatorGoalScored = (o1, o2) -> o2.getGoalScored() - o1.getGoalScored();
        Collections.sort(clubs, comparatorGoalScored);
        Comparator<Club> comparatorGoalDifferential = Comparator.comparingInt(Club::getGoalDifferential);
        Collections.sort(clubs, comparatorGoalDifferential);
        Comparator<Club> comparatorPoints = (o1, o2) -> o2.getPoints() - o1.getPoints();
        Collections.sort(clubs, comparatorPoints);
        terminalUI.displayCurrentTable(clubs);
    }

    private void handlePlayingMatchday() {
        MatchQueue currentQueue = game.getLeague().getSchedule().getFirstNotPlayedQueque();
        PlayMatchdayService playMatchdayService = new PlayMatchdayService();
        playMatchdayService.playMatchDay(currentQueue);
        handleMatchdayResults(currentQueue);
        terminalUI.displayQueueResult(currentQueue.getMatches());
        game.getLeague().getSchedule().getFirstNotPlayedQueque().setWasPlayed(true);
    }

    private void handleMatchdayResults(MatchQueue currentQueue) {
        for (Match match : currentQueue.getMatches()) {
            Club homeClub = match.getHomeClub();
            Club awayClub = match.getAwayClub();
            int homeClubGoals = match.getResult().getHomeTeamGoals();
            int awayClubGoals = match.getResult().getAwayTeamGoals();
            homeClub.addScoredGoals(homeClubGoals);
            homeClub.addLostGoals(awayClubGoals);
            homeClub.calculateGoalDifferential();
            awayClub.addScoredGoals(awayClubGoals);
            awayClub.addLostGoals(homeClubGoals);
            awayClub.calculateGoalDifferential();


            homeClub.addPoints(match.getResult().getResultHome().points);
            awayClub.addPoints(match.getResult().getResultAway().points);
        }
    }

    private Manager handleCreatingManager() {
        terminalUI.displayCreatingManagerHeader();
        terminalUI.displayNameQuery();
        String managerName = terminalUI.readText();
        terminalUI.readText();
        terminalUI.displaySurnameQuery();
        String managerSurname = terminalUI.readText();
        terminalUI.displayMaleQuery();
        Male managerMale = terminalUI.readMale();

        return new Manager(managerName, managerSurname, managerMale);
    }

    private void createGame(Manager manager, Club club, League league) throws IOException {
        game = new Game(manager, club, league);
    }

    private void exitGame() {
        System.exit(0);
    }
}
