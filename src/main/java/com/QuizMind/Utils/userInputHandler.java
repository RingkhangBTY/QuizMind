package com.QuizMind.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class userInputHandler {
    private String programmingLanguage_Subject;
    private String shortDes_Topic_Concepts;
    private String level;
    private int noOfQ;

    private String prompt;

    private Scanner sc = new Scanner(System.in);

    //Take user input to generate prompt
    private void getUserInput(){

        try {
            System.out.println("1. Enter the programming language / subject: ");
            programmingLanguage_Subject = sc.nextLine();
            System.out.println("2. Enter short description about your subject knowledge/topic/concepts: ");
            shortDes_Topic_Concepts = sc.nextLine();
            System.out.println("3.Choose level of test: (1.Beginner 2.Intermediate 3.Advanced)");
            while (true){
                int temp = sc.nextInt();
                if (temp==1){
                    level= "beginner"; break;
                } else if (temp ==2) {
                    level = "intermediate"; break;
                } else if (temp==3) {
                    level= "advanced"; break;
                }else {
                    System.out.println("Wrong input plz try again!!! ( Choose between 1-3 )");
                }
            }

            System.out.print("Enter number of questions:");
            noOfQ = sc.nextInt();
            sc.nextLine();


        }catch (InputMismatchException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }


    // creating prompt
    public String getPrompt(){

        getUserInput();

        prompt = "Hi, please generate " + noOfQ + " multiple-choice questions (MCQs) for the subject or " +
                "programming language: \"" + programmingLanguage_Subject + "\" " +
                "based on the topic/concepts: \"" + shortDes_Topic_Concepts + "\" " +
                "with difficulty level: \"" + level + "\". " +
                "Each question should have exactly 4 distinct options labeled as optionA, optionB, optionC, and optionD. " +
                "The correct answer should be provided as the exact text of the correct option (not just the letter). " +
                "Return the output in the following strict JSON format, and do not include any explanation or extra text " +
                "before or after the JSON:\n\n" +
                "{\n" +
                "  \"questions\": [\n" +
                "    {\n" +
                "      \"question\": \"<Question text>\",\n" +
                "      \"optionA\": \"<Option A>\",\n" +
                "      \"optionB\": \"<Option B>\",\n" +
                "      \"optionC\": \"<Option C>\",\n" +
                "      \"optionD\": \"<Option D>\",\n" +
                "      \"answer\": \"<Correct Option Text>\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n\n" +
                "Please ensure the questions are clear, relevant to the topic, and all options are distinct and plausible."
        ;


        return prompt;
    }

    public String userAns(){

        try {
            while (true){
                System.out.print("Your ans (A/B/C/D): ");
                String ans = sc.nextLine();

                if (ans.equalsIgnoreCase("A") ||
                        ans.equalsIgnoreCase("B")||
                        ans.equalsIgnoreCase("C") ||
                        ans.equalsIgnoreCase("D")){
                    return ans;
                }else {
                    System.out.println("Invalid input plz enter between (A/B/C/D).");
                }

            }

        }catch (InputMismatchException e){
            System.out.println("Error: "+e.getMessage());
        }

        return null;
    }
}