package com.QuizMind.Utils;

import com.QuizMind.Model.Questions;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParserUtil {

    public List<Questions> parseQuestionsFromJson() {
        FileUtil fileUtil = new FileUtil();
        String json = fileUtil.readJsonFromFile();

        Gson gson = new Gson();
        try {
            Type type = new TypeToken<Wrapper>() {}.getType();
            Wrapper wrapper = gson.fromJson(json, type);
            return wrapper.questions;
        } catch (JsonSyntaxException e) {
            System.err.println("Failed to parse JSON: " + e.getMessage());
            return null;
        }
    }

    // Inner class to match your JSON structure
    private static class Wrapper {
        List<Questions> questions;
    }
}
