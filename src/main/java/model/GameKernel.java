package model;

import model.converter.JSONLib;

public class GameKernel {
    private int nextQuestion;
    private final static int oneCost = 200;

    public GameKernel() {
        nextQuestion = 0;
    }

    public String getNextQuestion () {
        String question =  QuestionTools.getQuestion(nextQuestion);
        nextQuestion++;
        return question;
    }

    // @TODO реализовать метод подсчёта выигрыша
    public int getPrizeSize() {
        int cost = 0;
        for (int i = 1; i < nextQuestion; i++) {
            cost += oneCost * i;
        }
        return cost;
    }
}
