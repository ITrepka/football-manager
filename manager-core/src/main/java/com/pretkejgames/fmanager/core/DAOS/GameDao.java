package com.pretkejgames.fmanager.core.DAOS;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.pretkejgames.fmanager.core.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GameDao {
//    public static Game loadGame(String saveName) throws IOException {
//        List<String> lines = Files.readLines(new File(saveName), Charsets.UTF_8);
//
//        for(String line:lines){
//            //funkcje do wczytywania w formacie LEAGUE,wszystkie-pola
//            return new Game(manager, league, new Save(saveName));
//        }
//    }

    public static void saveGame(String saveName, Game game) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(saveName)) {
            fileOutputStream.write(game.toCSV());
        } catch (IOException e) {
            System.out.println("something wrong with saveGame");
        }
    }

//    private void handleSaveParticipants() {
//        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH)) {
//            participants(fileOutputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void participants(FileOutputStream fileOutputStream) throws IOException {
//        List<Partyable> allGuest = organizer.getAllGuest();
//        for (int i = 0; i < allGuest.size(); i++) {
//            fileOutputStream.write(allGuest.get(i).toCSV());
//            fileOutputStream.write('\n');
//        }
//    }


}
