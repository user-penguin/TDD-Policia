package model.converter;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONLibTest {
    @Test
    public void fileToJson () {
        JSONObject expected = JSONLib.getJsonFromFile("test.json");
        JSONObject actual = new JSONObject("{\"kek\": 1}");
        assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void fileToJsonArrayTest () {
        JSONObject expected = JSONLib.getJsonFromFile("arrayTest.json");
        JSONObject actual = new JSONObject("{\n" +
                " \"kek\":\n" +
                "      [\n" +
                "        {\"lol\":1},\n" +
                "        {\"azzaza\": 2} \n" +
                "      ]\n" +
                "}");
        assertEquals(actual.toString(), expected.toString());
    }
}
