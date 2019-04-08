package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTests {
    @Test
    public void getTrueAnswerByIdTest () {
        String expected = QuestionTools.getTrueAnswer(2);
        String actual = "майор";
        assertEquals(actual, expected);
    }

    @Test
    public void getQuestionByIdTest () {
        String expected = QuestionTools.getQuestion(2);
        String actual = "Какому званию соответствует погон с одной средней звездой?";
        assertEquals(actual, expected);
    }

    @Test
    public void getFakeAnswersByIdTest () {
        String[] expected = QuestionTools.getFakeAnswers(2);
        String[] actual = new String[]{"генерал-майор", "младший лейтенант", "поручик"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void getRandomPlace () {
        int expected1 = QuestionTools.getRandom();
        int expected2 = QuestionTools.getRandom();
        int expected3 = QuestionTools.getRandom();
        int expected4 = QuestionTools.getRandom();
        boolean expected =
                expected1 == expected2 &&
                expected1 == expected3 &&
                expected1 == expected4 &&
                expected2 == expected3 &&
                expected2 == expected4 &&
                expected3 == expected4;
        assertFalse(expected);

    }

    @Test
    public void checkTrueAnswer () {
        boolean expected = QuestionTools.checkAnswer("Мыло", 0);
        assertFalse(expected);
        expected = QuestionTools.checkAnswer("2", 0);
        assertTrue(expected);
    }

    @Test
    public void getCountQuestionsTest() {
        int expected = QuestionTools.getCountQuestions();
        int actual = 3;
        assertEquals(expected, actual);
    }
}
