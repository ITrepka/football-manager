package com.pretkejgames.fmanager.core.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends File {
    private String name;
    private String path;
    private FileWriter fileWriter;
    private static int saveID = 0;

    public Save() {
        super("save" + saveID++ + ".txt");
        path = "save" + saveID++ + ".txt";
        //todo
        try (FileWriter fileWriter= new FileWriter(path)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Save(String name) {
        //todo
        super(name + ".txt");
        path = name + ".txt";
        try (FileWriter fileWriter= new FileWriter(path)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }
}
