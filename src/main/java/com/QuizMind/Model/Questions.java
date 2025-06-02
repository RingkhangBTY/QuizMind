package com.QuizMind.Model;

public class Questions {
    private String question;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    
    private String answer;


    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "optionsA='" + optionA + '\'' +
                ", optionsB='" + optionB + '\'' +
                ", optionsC='" + optionC + '\'' +
                ", optionsD='" + optionD + '\'' +
                '}';
    }
}