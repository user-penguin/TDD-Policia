package model;

import model.converter.JSONLib;
import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionTools {
    public static String getTrueAnswer(int i) {
        JSONObject modules = JSONLib.getJsonFromFile("/json/answers_and_questions.json");
        JSONArray questions = modules.getJSONArray("modules");
        JSONArray concreteQuestion = questions.getJSONArray(2);
        String result = concreteQuestion.getJSONObject(2).get("answer_true").toString();
        return result;
    }

    // @TODO реализовать метод поиска вопроса по ИД
    public static String getQuestion(int i) {
        return "Какому званию соответствует погон с одной средней звездой?";
    }
}
