package com.pretkejgames.fmmanager.console;

import com.pretkejgames.fmanager.core.model.*;

import java.util.Date;

public class Controller {
    TerminalUI terminalUI;
    Game game;

    {
        terminalUI = new TerminalUI();
    }

    public void runGame() {
        handleMenuOptions();
    }

    private void handleMenuOptions() {
        terminalUI.displayStartMenu();
        handleMenuChoice(terminalUI.readUserChoice());
    }

    private void handleMenuChoice(MenuOptions userMenuChoice) {
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

    private void handleStartNewGame() {
        Manager manager = handleCreatingManager();
        Club club = handleCreatingClub();
        createGame(manager, club);
        game.newGameAutoSave();
        gameLoop();
    }

    private Club handleCreatingClub() {
        terminalUI.displayNameClubQuery();
        return new Club(terminalUI.readText());
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
                game.playMatchday();
                terminalUI.displayQueueResult(game.getLeague().getSchedule().getQueue().getResults());
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
        terminalUI.displaySurnameQuery();
        String managerSurname = terminalUI.readText();
        terminalUI.displayMaleQuery();
        Male managerMale = terminalUI.readMale();

        return new Manager(managerName, managerSurname, managerMale);
    }

    private void createGame(Manager manager, Club club) {
        game = new Game(manager, club);
    }

    private void exitGame() {
        System.exit(0);
    }
}
