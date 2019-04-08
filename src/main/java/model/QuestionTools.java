package model;

import model.converter.JSONLib;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

public class QuestionTools {
    private static boolean previous = false;
    public static String getTrueAnswer(int i) {
        JSONObject modules = JSONLib.getJsonFromFile("/json/answers_and_questions.json");
        JSONArray questions = modules.getJSONArray("modules");
        JSONArray concreteQuestion = questions.getJSONArray(i);
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

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(4);
    }

    public static boolean checkAnswer(String answer, int i) {
        if (getTrueAnswer(i).equals(answer)) {
            return true;
        }
        return false;
    }

    // @TODO добавить получение размера
    public static int getCountQuestions() {
        return 3;
    }
}
