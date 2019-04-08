package model.converter;

import model.io_tools.ReadFile;
import org.json.JSONObject;

public class JSONLib {
    public static JSONObject getJsonFromFile(String path) {
        return new JSONObject(ReadFile.getText(path));
    }
}
