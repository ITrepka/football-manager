package com.pretkejgames.fmmanager.samples;

import com.pretkejgames.fmanager.core.model.Club;
import com.pretkejgames.fmanager.core.model.Save;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readLines(new File("startGame.txt"), Charsets.UTF_8);

        for(String line:lines){
            System.out.println(line);
        }
    }
}
