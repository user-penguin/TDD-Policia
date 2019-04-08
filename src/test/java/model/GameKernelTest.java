package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameKernelTest {
    @Test
    public void getNextQuestionTest () {
        GameKernel gameKernel = new GameKernel();
        String expected = gameKernel.getNextQuestion();
        String actual = "Сколько белых полосок на жезле инспектора ГИБДД?";
        assertEquals(actual, expected);
        expected = gameKernel.getNextQuestion();
        actual = "После какой фразы нужно вызывать сотрудников СОБР?";
        assertEquals(actual, expected);
    }

    @Test
    public void getPrizeSizeTest () {
        GameKernel gameKernel = new GameKernel();
        gameKernel.getNextQuestion();
        gameKernel.getNextQuestion();
        gameKernel.getNextQuestion();
        int expected = gameKernel.getPrizeSize();
        int actual = 600;
        assertEquals(actual, expected);
    }
}
