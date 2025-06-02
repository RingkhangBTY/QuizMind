package com.QuizMind.Logic;

import com.QuizMind.Model.Questions;
import com.QuizMind.Service.GeminiService;
import com.QuizMind.Utils.FileUtil;
import com.QuizMind.Utils.JsonParserUtil;
import com.QuizMind.Utils.userInputHandler;


import java.util.List;

public class QuizManager {

    private int correctAns;
    private int totalQuestion;

    public void start() {
        GeminiService geminiService = new GeminiService();
        userInputHandler userInputHandler = new userInputHandler();

        FileUtil fileUtil = new FileUtil();
        fileUtil.saveJsonToFile(geminiService.getResponse());

        JsonParserUtil jsonParserUtil = new JsonParserUtil();
        List<Questions> questions = jsonParserUtil.parseQuestionsFromJson();
        totalQuestion = questions.size();

        if (questions.isEmpty()){
            return;
        }

        int iter = 1;
        for (Questions q : questions){
            System.out.println("Q"+iter+". "+q.getQuestion());
            System.out.println("A. "+q.getOptionA());
            System.out.println("B. "+q.getOptionB());
            System.out.println("C. "+q.getOptionC());
            System.out.println("D. "+q.getOptionD());
            String ans = userInputHandler.userAns().toUpperCase();
            System.out.println("Correct ans: "+q.getAnswer());
            switch (ans){
                case "A":
                    if (isCorrect(q.getOptionA(),q.getAnswer())) correctAns++;
                    break;
                case "B":
                    if (isCorrect(q.getOptionB(),q.getAnswer())) correctAns++;
                    break;
                case "C":
                    if (isCorrect(q.getOptionC(),q.getAnswer())) correctAns++;
                    break;
                case "D":
                    if (isCorrect(q.getOptionD(),q.getAnswer())) correctAns++;
                    break;
                default:
                    System.out.println("Error: Unexpected error plz try again!!");
            }

            iter++;
            System.out.println();
        }
    }


    public void displayScore() {
        System.out.println("-----Your core card-----");
        System.out.println("Total questions: "+ totalQuestion);
        System.out.println("Correct answer: "+ correctAns);
        float accuracy = ((float) correctAns/totalQuestion)*100;
        System.out.printf("Your accuracy: %.2f \n", accuracy);
        System.out.println("You score "+correctAns+" out of "+totalQuestion);
    }

    private boolean isCorrect(String userAns, String correctAns){
        return userAns.equalsIgnoreCase(correctAns);
    }
}