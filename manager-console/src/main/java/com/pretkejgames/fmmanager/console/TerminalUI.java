package com.pretkejgames.fmmanager.console;

import com.pretkejgames.fmanager.core.model.Club;
import com.pretkejgames.fmanager.core.model.Game;
import com.pretkejgames.fmanager.core.model.Male;
import com.pretkejgames.fmanager.core.model.Match;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TerminalUI {
    Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    public void displayStartMenu() {
        System.out.println("Welcome to Football Club Manager!");
        System.out.printf("1 - Start New Game\n2 - Load Game\n3 - Exit\n");
    }

    public MenuOptions readUserChoice() {
        switch (scanner.nextInt()) {
            case 1:
                return MenuOptions.START_NEW_GAME;
            case 2:
                return MenuOptions.LOAD_GAME;
            case 3:
                return MenuOptions.EXIT;
            default:
                System.out.println("Bad Choice! Type the number once again");
                readUserChoice();
        }
        //todo
        return null;
    }

    public GameOptions readUserChoiceGameWindow() {
        switch (scanner.nextInt()) {
            case 1:
                return GameOptions.PLAY;
            case 2:
                return GameOptions.SAVE_GAME;
            case 3:
                return GameOptions.LOAD_GAME;
            case 4:
                return GameOptions.EXIT;
            default:
                System.out.println("Bad Choice! Type the number once again");
                readUserChoiceGameWindow();
        }
        //todo
        return null;
    }

    public void displayNameQuery() {
        System.out.println("Write manager's name: ");
    }

    public void displayCreatingManagerHeader() {
        System.out.println("--- Create Manager! ---");
    }

    public String readText() {
        scanner.reset();
        return scanner.nextLine();
    }

    public void displayNameClubQuery() {
        System.out.println("--- Club creating ---");
        System.out.println("Write your club name: ");
    }

    public void displayGameWindow(Game game) {
        System.out.println("1 - Play\n2 - Save Game\n3 - Load Game\n4 - Exit\n");
    }

    public void displayQueueResult(Set<Match> results) {
        StringBuilder sb = new StringBuilder();

        for (Match match : results) {
            sb.append(String.format("%s %d - %d %s\n",
                    match.getHomeClub().getName(),
                    match.getResult().getHomeTeamGoals(),
                    match.getResult().getAwayTeamGoals(),
                    match.getAwayClub().getName()));
        }

        System.out.println(sb.toString());
    }

    public void displaySurnameQuery() {
        System.out.println("Surname: ");
    }

    public void displayMaleQuery() {
        System.out.println("Male (M/F): ");
    }

    public Male readMale() {
        return scanner.next().equals("M") ? Male.MALE : Male.FEMALE;
    }

    public PlayOptions readPlayWindowChoice() {
        System.out.println("1 - Play Matchday\n2 - Display current table\n3 - Display Schedule\n4 - Back To Game Options\n");
        switch (scanner.nextInt()) {
            case 1:
                return PlayOptions.PLAY_MATCH;
            case 2:
                return PlayOptions.DISPLAY_CURRENT_TABLE;
            case 3:
                return PlayOptions.DISPLAY_SCHEDULE;
            case 4:
                return PlayOptions.BACK;
            default:
                System.out.println("Bad Choice! Type the number once again");
                readUserChoiceGameWindow();
                throw new RuntimeException("Something wrong happened");
        }
    }

    public void displayCurrentTable(List<Club> clubs) {
        System.out.println("Place\tName\tGoals Scored\tLost Goals\tGoalDifferential\tPoints");
        for (int i = 0; i < clubs.size(); i++) {
            System.out.printf("%d\t%s\t%d\t%d\t%d\t%d pkt\n",
                    i + 1,
                    clubs.get(i).getName(),
                    clubs.get(i).getGoalScored(),
                    clubs.get(i).getLostGoals(),
                    clubs.get(i).getGoalDifferential(),
                    clubs.get(i).getPoints());
        }
    }
}
