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

    public static String[] getFakeAnswers(int i) {
        JSONObject modules = JSONLib.getJsonFromFile("/json/answers_and_questions.json");
        JSONArray questions = modules.getJSONArray("modules");
        JSONArray concreteQuestion = questions.getJSONArray(i);
        JSONArray arrayOfWrongAnswers = concreteQuestion.getJSONObject(1).getJSONArray("answer_wrong");
        String[] wrongAnswers = new String[3];
        for (int k = 0; k < arrayOfWrongAnswers.length(); k++) {
            wrongAnswers[k] = arrayOfWrongAnswers.getString(k);
        }
        return wrongAnswers;
    }
}
