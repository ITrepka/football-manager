package com.pretkejgames.fmanager.core.DAOS;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.pretkejgames.fmanager.core.model.Club;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeagueDAO {
    public List<Club> loadClubs() throws IOException {
        List<String> lines = Files.readLines(new File("C:/Users/User/training-workspace/old-school-manager/data/start_clubs.txt"), Charsets.UTF_8);
        List<Club> clubs = new ArrayList<>();
        for(String line:lines){
            clubs.add(new Club(line));
        }
        return clubs;
    }
}
