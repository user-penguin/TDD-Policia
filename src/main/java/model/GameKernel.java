package model;

import model.converter.JSONLib;

public class GameKernel {
    private int nextQuestion;
    private int countOfQustions;
    private final static int oneCost = 200;

    public GameKernel() {
        nextQuestion = 0;
        countOfQustions = QuestionTools.getCountQuestions();
    }

    public String getNextQuestion () {
        String question =  QuestionTools.getQuestion(nextQuestion);
        nextQuestion++;
        return question;
    }

    public int getPrizeSize() {
        int cost = 0;
        for (int i = 1; i < nextQuestion; i++) {
            cost += oneCost * i;
        }
        return cost;
    }

    public int getCurrentQuestion() {
        return nextQuestion - 1;
    }

    // @TODO реализовать получение количества вопросов
    public int getCountOfQuestions() {
        return 3;
    }
}
