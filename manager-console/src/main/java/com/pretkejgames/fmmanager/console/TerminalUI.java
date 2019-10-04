package com.pretkejgames.fmmanager.console;

import java.util.Scanner;

public class TerminalUI {
    Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    public void displayStartMenu() {
        System.out.printf("Welcome to Football Club Manager!\n");
        System.out.printf("1 - Start New Game\n2 - Load Game\n3 - Exit");
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

    public void displayNameQuery() {
        System.out.println("Write manager's name: ");
    }

    public void displayCreatingManagerHeader() {
        System.out.println("--- Create Manager! ---");
    }

    public String readText() {
        return scanner.nextLine();
    }
}
