package model;

import model.converter.JSONLib;

public class GameKernel {
    private int nextQuestion;
    public GameKernel() {
        nextQuestion = 0;
    }

    public String getNextQuestion () {
        String question =  QuestionTools.getQuestion(nextQuestion);
        nextQuestion++;
        return question;
    }
}
