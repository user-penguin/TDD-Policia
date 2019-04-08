package model;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
}
