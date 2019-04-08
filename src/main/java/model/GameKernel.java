package model;

public class GameKernel {
    private int nextQuestion;
    public GameKernel() {
        nextQuestion = 0;
    }

    // @TODO реализовать метод получения следующего вопроса
    public String getNextQuestion () {
        return "Сколько белых полосок на жезле инспектора ГИБДД?";
    }
}
