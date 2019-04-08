package model.io_tools;

import java.io.*;

public class ReadFile {
    // @TODO реализовать получение текста из файла
    public static String getText (String path) {
        String pathToFile = ReadFile.class.getResource(path).getPath();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String result = bufferedReader.readLine();
            String unit = "";
            while((unit = bufferedReader.readLine()) != null) {
                result += "\n" + unit;
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
