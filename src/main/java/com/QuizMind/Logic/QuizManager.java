package com.QuizMind.Logic;

import com.QuizMind.Model.Questions;
import com.QuizMind.Service.GeminiService;
import com.QuizMind.Utils.FileUtil;
import com.QuizMind.Utils.JsonParserUtil;

import java.util.List;

public class QuizManager {

    public void start() {
        GeminiService geminiService = new GeminiService();

        FileUtil fileUtil = new FileUtil();
        fileUtil.saveJsonToFile(geminiService.getResponse());

        JsonParserUtil jsonParserUtil = new JsonParserUtil();
        List<Questions> questions = jsonParserUtil.parseQuestionsFromJson();

        if (questions==null || questions.isEmpty()){
//            System.out.println();
            return;
        }
        for (Questions q : questions){
            System.out.println(q.getQuestion());
            System.out.println("A. "+q.getOptionA());
            System.out.println("B. "+q.getOptionB());
            System.out.println("C. "+q.getOptionC());
            System.out.println("D. "+q.getOptionD());

            System.out.println();
        }
    }
}