package model;

import org.junit.Test;
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
}
