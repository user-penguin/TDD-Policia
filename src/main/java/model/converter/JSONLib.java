package model.converter;

import org.json.JSONObject;

public class JSONLib {
    // @TODO реализовать чтение джсона из файла
    public static JSONObject getJsonFromFile(String path) {
        return new JSONObject("{\"kek\": 1}");
    }
}
