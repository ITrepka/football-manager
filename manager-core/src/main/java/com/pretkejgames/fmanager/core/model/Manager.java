package com.pretkejgames.fmanager.core.model;

public class Manager {
    private String name;
    private String surname;
    private Male male;
    private Club club;
    //photo

    public Manager(String name, String surname, Male male) {
        this.name = name;
        this.surname = surname;
        this.male = male;
    }

    @Override
    public String toString() {
        return String.format("MANAGER,%s,%s,%s,%s", name, surname, male == Male.MALE ? "MALE" : "FEMALE", club);
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Male getMale() {
        return male;
    }

    public void setMale(Male male) {
        this.male = male;
    }
}
