package model.io_tools;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReadFileTests {
    @Test
    public void readFromFileTest() {
        String expected = ReadFile.getText("testFile.txt");
        String actual = "Я тестовый текст";
        assertEquals(actual, expected);
    }

    @Test
    public void manyLinesReadTest() {
        String expected = ReadFile.getText("manyLines.txt");
        String actual = "абв\nгде\n ж";
        assertEquals(actual, expected);
    }
}
