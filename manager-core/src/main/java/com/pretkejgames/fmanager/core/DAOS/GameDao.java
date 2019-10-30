package com.pretkejgames.fmanager.core.DAOS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pretkejgames.fmanager.core.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GameDao {
    public final String PATH = "data/";
    public void saveGame(String saveName, Game game) throws IOException {
        File targetFile = new File(PATH + saveName + ".json");
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(targetFile, game);
    }
//    public static Game loadGame(String saveName) throws IOException {
//        List<String> lines = Files.readLines(new File(saveName), Charsets.UTF_8);
//
//        for(String line:lines){
//            //funkcje do wczytywania w formacie LEAGUE,wszystkie-pola
//            return new Game(manager, league, new Save(saveName));
//        }
//    }


}
