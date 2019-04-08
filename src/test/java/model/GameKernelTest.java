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
    }
}
