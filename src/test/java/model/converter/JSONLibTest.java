package model.converter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONLibTest {
    @Test
    public void fileToJson () {
        JSONObject expected = JSONLib.getJsonFromFile("/json/test.json");
        JSONObject actual = new JSONObject("{\"kek\": 1}");
        assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void fileToJsonArrayTest () {
        JSONObject expected = JSONLib.getJsonFromFile("/json/arrayTest.json");
        JSONObject actual = new JSONObject("{\n" +
                " \"kek\":\n" +
                "      [\n" +
                "        {\"lol\":1},\n" +
                "        {\"azzaza\": 2} \n" +
                "      ]\n" +
                "}");
        assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void readQuestionsTest() {
        JSONObject modules = JSONLib.getJsonFromFile("/json/answers_and_questions.json");
        JSONArray questions = modules.getJSONArray("modules");
        JSONArray concreteQuestion = questions.getJSONArray(0);
        String expected = concreteQuestion.getJSONObject(0).get("question").toString();
        String actual = "Сколько белых полосок на жезле инспектора ГИБДД?";
        assertEquals(actual, expected);
    }
}
