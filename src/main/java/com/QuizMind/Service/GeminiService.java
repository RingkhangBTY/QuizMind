package com.QuizMind.Service;
import com.QuizMind.Utils.*;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import java.io.IOException;
import java.net.ConnectException;

public class GeminiService {
    private String res;
    private String prompt;

    public GeminiService(){
        executePrompt();
    }

    private void executePrompt(){
        try {
            Client clint = new Client();
            userInputHandler userInputHandler = new userInputHandler();
            prompt = userInputHandler.getPrompt();
            GenerateContentResponse response =
                    clint.models.generateContent("gemini-2.0-flash-001",prompt,null);

            res = response.text();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public String getResponse(){
        int start = res.indexOf('{');
        int end = res.lastIndexOf('}');

        if (start != -1 && end != -1 && end > start) {
            return res.substring(start, end + 1);
        } else {
            System.err.println("No valid JSON object found in the response.");
            return null;
        }
    }
}