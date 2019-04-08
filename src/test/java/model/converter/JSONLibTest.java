package model.converter;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONLibTest {
    @Test
    public void fileToJson() {
        JSONObject expected = JSONLib.getJsonFromFile("test.json");
        JSONObject actual = new JSONObject("{\"kek\": 1}");
        assertEquals(actual.toString(), expected.toString());
    }
}
