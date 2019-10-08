package com.pretkejgames.fmanager.core.model;

import java.io.*;
import java.util.List;

public class Data {
    public static File leagues;
    public File SAVE = new File("save.txt");
    public FileReader fileReader;
    public FileOutputStream fileOutputStream;



    public Data() {
//        try {
//            this.SAVE = fileReader.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public League getLeague() {

        System.out.println(SAVE.toString());
    }
}
