package com.pretkejgames.fmmanager.console;

import com.pretkejgames.fmanager.core.model.Club;
import com.pretkejgames.fmanager.core.model.Game;
import com.pretkejgames.fmanager.core.model.Male;
import com.pretkejgames.fmanager.core.model.Manager;

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
                handleLoadGame();
            case EXIT:
                exitGame();
        }
    }

    private void handleStartNewGame() {
        handleCreatingManager();
    }

    private void handleCreatingManager() {
        terminalUI.displayCreatingManagerHeader();
        terminalUI.displayNameQuery();
        String managerName = terminalUI.readText();
        terminalUI.displaySurnameQuery();
        String managerSurname = terminalUI.readText();
        terminalUI.displayMaleQuery();
        Male managerMale = terminalUI.readMale();

        Manager manager = new Manager(managerName, managerSurname, managerMale)
        game = new Game(manager);
    }

    private void exitGame() {
        System.exit(0);
    }
}
