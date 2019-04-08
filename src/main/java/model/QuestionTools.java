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

    public static String getQuestion(int i) {
        JSONObject modules = JSONLib.getJsonFromFile("/json/answers_and_questions.json");
        JSONArray questions = modules.getJSONArray("modules");
        JSONArray concreteQuestion = questions.getJSONArray(i);
        String result = concreteQuestion.getJSONObject(0).get("question").toString();
        return result;
    }

    // @TODO получение неправильных ответов для викторины по ИД
    public static String[] getFakeAnswers(int i) {
        return new String[]{"генерал-майор", "младший лейтенант", "поручик"};
    }
}
