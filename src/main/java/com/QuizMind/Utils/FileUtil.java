package com.QuizMind.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {


    private String fileName = "questions.json";

    public void saveJsonToFile(String json) {
        try {
            Files.write(
                    Paths.get(fileName),
                    json.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("JSON saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving JSON to file: " + e.getMessage());
        }
    }


    public String readJsonFromFile() {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.err.println("Error reading JSON from file: " + e.getMessage());
            return null;
        }
    }

}
