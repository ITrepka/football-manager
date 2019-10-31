package com.pretkejgames.fmmanager.console;

import com.pretkejgames.fmanager.core.DAOS.LeagueDAO;
import com.pretkejgames.fmanager.core.model.*;

import java.io.IOException;
import java.util.Date;

public class Controller {
    TerminalUI terminalUI;
    Game game;

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
            case PLAY_MATCH:
                MatchQueue currentQueue = game.getLeague().getSchedule().getQueue();
                PlayMatchdayService playMatchdayService = new PlayMatchdayService();
                playMatchdayService.playMatchDay(currentQueue);
                terminalUI.displayQueueResult(game.getLeague().getSchedule().getQueue().getMatches());
                game.getLeague().getSchedule().getQueue().setNumber(currentQueue.getNumber() + 1);
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
