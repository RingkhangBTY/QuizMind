package com.QuizMind;

import com.QuizMind.Logic.QuizManager;

public class Main {
    public static void main(String[] args) {

//        QuizManager quizManager = new QuizManager();
        QuizManager quizManager = null;
        boolean cont = true;

        while (cont){
            quizManager = new QuizManager();
            quizManager.start();
            cont = quizManager.displayScore();
        }

    }
}