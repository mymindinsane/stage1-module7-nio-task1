package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        List<String> dataFromFile;
        try (Stream<String> lines = Files.lines(Paths.get(file.toURI()), StandardCharsets.UTF_8)) {
            dataFromFile = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProfileInvalidDataException(e.getMessage());
        }
        return (getDataFromList(dataFromFile));
    }

    public Profile getDataFromList(List<String> dataToExtractFrom) {
        String name = dataToExtractFrom.get(0).substring(dataToExtractFrom.get(0).
                lastIndexOf(':') + 1).trim();
        Integer age = Integer.valueOf(dataToExtractFrom.get(1).substring(dataToExtractFrom.get(1).
                lastIndexOf(':') + 1).trim());
        String email = dataToExtractFrom.get(2).substring(dataToExtractFrom.get(2).
                lastIndexOf(':') + 1).trim();
        Long phone = Long.valueOf(dataToExtractFrom.get(3).substring(dataToExtractFrom.
                get(3).lastIndexOf(':') + 1).trim());
        return new Profile(name, age, email, phone);
    }
}

