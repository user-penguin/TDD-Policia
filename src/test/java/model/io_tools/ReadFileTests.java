package model.io_tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadFileTests {
    @Test
    public void readFromFileTest() {
        String expected = ReadFile.getText("testFile.txt");
        String actual = "Я тестовый текст";
        assertEquals(expected, actual);
    }
}
