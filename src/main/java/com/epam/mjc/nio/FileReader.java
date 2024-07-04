package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        List<String> allLines;
        try {
            allLines = Files.readAllLines(Paths.get("resources/Profile.txt"));
        } catch (IOException e) {
            throw new ProfileInvalidDataException(e.getMessage());
        }

        return new Profile();
    }
}
