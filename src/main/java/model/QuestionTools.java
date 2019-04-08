package model;

import model.converter.JSONLib;
import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionTools {
    private static boolean previous = false;
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

    // @TODO реализовать метод получения рандомного числа от 1 до 4
    public static int getRandom() {
        if (previous) {
            previous = false;
            return 2;
        } else {
            previous = true;
            return 1;
        }
    }
}
